use quan_ly_sinh_vien;

SELECT * FROM student1;	

SELECT * FROM student1 WHERE `status` = true;

SELECT * FROM `subject` WHERE credit <10;

SELECT S.student_id, S.student_name, C.class_name
FROM student1 S join class C on S.class_id = C.class_id;

SELECT S.student_id, S.student_name, sub.sub_name, M.mark
FROM student1 S join mark M on S.student_id = student_id join `subject` sub on M.sub_id = sub_id;