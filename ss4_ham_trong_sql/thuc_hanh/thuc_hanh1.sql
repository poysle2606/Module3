use quan_ly_sinh_vien;

select address ,count(student_id)
from student1 as dia_chi 
group by address;
 
select s.student_name, avg(m.mark)
from student1 s 
join mark m on m.student_id = s.student_id
group by s.student_name;

select s.student_name, avg(m.mark) as diem_lon_hon_6
from student1 s 
join mark m on m.student_id = s.student_id
group by s.student_name having diem_lon_hon_6 > 6;

 select s.student_name, avg(m.mark) as diem_lon_hon_6
from student1 s 
join mark m on m.student_id = s.student_id
group by s.student_name having diem_lon_hon_6 >= all (select avg(mark) from mark group by mark.student_id);