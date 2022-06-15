use quan_ly_sinh_vien;

SELECT * FROM student1 
WHERE (student_name like 'h%');

SELECT * FROM class
WHERE MONTH(start_date) = 12;

SELECT * FROM `subject`
WHERE credit between 3 AND 5;

UPDATE student1 SET class_id = 2 WHERE student_name = 'Hung';

-- Hiển thị các thông tin: StudentName, SubName, Mark.
--  Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.

SELECT student_name, mark, sub_name
FROM student1 
join mark on student1.student_id = mark.student_id
join `subject` on  mark.sub_id = `subject`.sub_id
ORDER BY mark desc , student_name;

