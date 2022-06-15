use quan_ly_sinh_vien;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.

select *  from `subject`
group by credit 
having max(credit) >= all (select max(credit) from `subject` group by `subject`.sub_id);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.

select s.*, max(mark) as max_point
from `subject` s
join mark m on s.sub_id = m.sub_id
group by sub_id 
having max(mark) >= all (select max(mark) from mark group by mark.sub_id);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dầ

select st.*, avg(mark) as diem_trung_binh
from student1 st 
join mark m on m.student_id = st.student_id
group by student_id
order by mark desc;
