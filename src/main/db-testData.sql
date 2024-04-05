-- --------------------
-- Test data insertion
-- --------------------

use scholarships;

insert into scholarships.student(student_id, first_name, last_name, email, password)
values
("210756100052", "Gjon", "Hajdari", "gjon.hajdari@student.uni-pr.edu", "12345"),
("220756100031", "Lorik", "Agaj", "lorik.agaj@student.uni-pr.edu", "12345"),
("220756100004", "Dion", "Gashi", "dion.gashi@student.uni-pr.edu", "12345"),
("220756100036", "Diell", "Doçi", "diell.doci@student.uni-pr.edu", "12345"),
("220757100075", "Blerton", "Ismaili", "blerton.ismaili@student.uni-pr.edu", "12345"),
("220756100109", "Gent", "Podvorica", "gent.podvorica@student.uni-pr.edu", "12345");

insert into scholarships.voucher(title, amount, deadline)
values
("Scholarship 1", 1000.00, "2024-04-30"),
("Scholarship 2", 2000.00, "2024-02-21");

insert into scholarships.application(student_id, voucher_id, application_date)
values 
("210756100052", 1, "2024-04-20"),
("220756100031", 1, "2024-04-22"),
("220756100004", 2, "2024-01-22");

insert into scholarships.awardees(student_id, voucher_id, award_date)
values
("210756100052", 1, "2024-04-30"),
("220756100031", 1, "2024-05-02"),
("220756100004", 2, "2024-02-02");