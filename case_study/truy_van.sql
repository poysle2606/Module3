use case_study;

							 -- task 2--

SELECT * FROM nhan_vien 
WHERE(ho_ten LIKE 'H%' OR ho_ten LIKE 'K%' OR ho_ten LIKE 'T%' ) AND char_length(ho_ten) <= 15;

                             -- task 3--
SELECT * FROM khach_hang 
WHERE ((YEAR(CURDATE()) - YEAR(ngay_sinh)) BETWEEN 18 and 50) AND (dia_chi LIKE '%Đà Nẵng' OR dia_chi LIKE '%Quảng Trị');

                             -- task 4--
select kh.ma_khach_hang, kh.ho_ten , lk.ten_loai_khach, count(kh.ma_khach_hang) as so_lan_dat_phong
from loai_khach lk
join khach_hang kh on lk.ma_loai_khach = kh.ma_loai_khach
join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
where lk.ma_loai_khach = 1
group by kh.ma_khach_hang

                             -- task 5--
                             
                             