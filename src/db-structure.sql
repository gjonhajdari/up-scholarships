-- --------------------
-- Database structure
-- --------------------

create database if not exists scholarships;

use scholarships;

create table if not exists scholarships.student(
	student_id char(12) not null,
  first_name nvarchar(30) not null,
  last_name nvarchar(30) not null,
  email nvarchar(320) not null,
  salt varchar(44) not null,
  password varchar(256) not null,
  primary key (student_id)
);

create table if not exists scholarships.voucher(
  voucher_id int not null auto_increment,
  title nvarchar(255) not null,
  amount decimal(10, 2) not null,
  category nvarchar(30) not null, -- UNIVERSITY, STEM, ARTS, OTHER
  description text not null,
  deadline date not null,
  primary key (voucher_id)
);

create table if not exists scholarships.application(
  application_id int not null auto_increment,
  student_id char(12) not null,
  voucher_id int not null,
  application_date datetime not null default current_timestamp,
  status nvarchar(30) DEFAULT 'PENDING', -- PENDING, APPROVED, REJECTED
  primary key (application_id),
  foreign key (student_id) references student(student_id),
  foreign key (voucher_id) references voucher(voucher_id)
);

create table if not exists scholarships.admin(
  admin_id int not null auto_increment,
  username nvarchar(30) not null,
  salt varchar(100) not null,
  password varchar(256) not null,
  primary key (admin_id)
);

-- --------------------
-- Triggers
-- --------------------

-- Checks if the deadline for a voucher has passed when applying

DELIMITER //

CREATE TRIGGER scholarships.check_voucher_deadline
BEFORE INSERT ON scholarships.application
FOR EACH ROW
BEGIN
    DECLARE deadline_passed BOOLEAN;

    SELECT TRUE INTO deadline_passed
    FROM scholarships.voucher
    WHERE voucher_id = NEW.voucher_id
    AND DATE(deadline) < DATE(NEW.application_date);

    -- If the deadline has passed, raise an error
    IF deadline_passed THEN
        SIGNAL SQLSTATE "45000"
        SET MESSAGE_TEXT = "Application deadline has passed. Cannot apply for scholarship.";
    END IF;
END;
//


-- --------------------
-- Strored procedures
-- --------------------


DELIMITER //

CREATE PROCEDURE insert_voucher_random(IN title NVARCHAR(255), IN amount DECIMAL(10,2), IN category NVARCHAR(30), IN description TEXT)
BEGIN
  DECLARE randomDateFuture DATETIME;
  SET randomDateFuture = NOW() + INTERVAL FLOOR(RAND() * 180) DAY;

  INSERT INTO scholarships.voucher(title, amount, category, description, deadline)
  VALUES (title, amount, category, description, randomDateFuture);
END//

DELIMITER ;


DELIMITER //

CREATE PROCEDURE insert_application_random(IN studentId CHAR(12), IN voucherId INT)
BEGIN
  DECLARE randomDatePast DATETIME;
  DECLARE randomStatus ENUM('PENDING', 'APPROVED', 'REJECTED');
  SET randomDatePast = NOW() - INTERVAL FLOOR(RAND() * 180) DAY;
  SET randomStatus = ELT(1 + FLOOR(RAND() * 3), 'PENDING', 'APPROVED', 'REJECTED');

  INSERT INTO scholarships.application(voucher_id, student_id, application_date, status)
  VALUES (voucherId, studentId, randomDatePast, randomStatus);
END//

DELIMITER ;