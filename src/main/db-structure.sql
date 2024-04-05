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
  password char(64) not null,
  primary key (student_id)
);

create table if not exists scholarships.voucher(
  voucher_id int not null auto_increment,
  title nvarchar(100) not null,
  amount decimal(10, 2) not null,
  deadline date not null,
  primary key (voucher_id),
  foreign key (student_id) references student(student_id)
);

create table if not exists scholarships.application(
  application_id int not null auto_increment,
  student_id char(12) not null,
  voucher_id int not null,
  application_date date not null,
  primary key (application_id),
  foreign key (student_id) references student(student_id),
  foreign key (voucher_id) references scholarship(voucher_id)
);

create table if not exists scholarships.awardees(
  student_id char(12) not null,
  voucher_id int not null,
  award_date date not null,
  primary key (student_id, voucher_id),
  foreign key (student_id) references student(student_id),
  foreign key (voucher_id) references scholarship(voucher_id)
);