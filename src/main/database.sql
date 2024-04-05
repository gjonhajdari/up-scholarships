create database if not exists knk_projekti;

create table if not exists knk_projekti.student(
	student_id char(12) not null,
  first_name nvarchar(30) not null,
  last_name nvarchar(30) not null,
  password nvarchar(64) not null,
  primary key (student_id)
);

insert into knk_projekti.student(student_id, first_name, last_name, password)
values
("210756100052", "Gjon", "Hajdari", "12345"),
("220756100034", "Lorik", "Agaj", "12345");

drop table knk_projekti.student;