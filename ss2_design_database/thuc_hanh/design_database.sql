CREATE DATABASE quan_ly_diem_thi;

use quan_ly_diem_thi;
CREATE TABLE student(
code_student INT auto_increment PRIMARY KEY,
name_student VARCHAR(45),
birthday date,
class VARCHAR(10),
gender VARCHAR(10));

CREATE TABLE mon_hoc(
code_subject INT auto_increment PRIMARY KEY,
name_subjcet VARCHAR(20)
);

CREATE TABLE point_of_student(
code_student INT,
code_subject INT,
point_text INT,
date_text date,
PRIMARY KEY(code_student,code_subject),
foreign key(code_student) references student(code_student),
foreign key(code_subject) references mon_hoc(code_subject));

CREATE TABLE teacher(
code_teacher INT auto_increment PRIMARY KEY,
name_teacher VARCHAR(45),
numberphone int);

alter table mon_hoc add code_teacher INT;
alter table mon_hoc add constraint ma_gv foreign key(code_teacher) references teacher(code_teacher);