USE case_study;

							 -- task 2--

SELECT * FROM nhan_vien 
WHERE(ho_ten LIKE 'H%' OR ho_ten LIKE 'K%' OR ho_ten LIKE 'T%' ) AND char_length(ho_ten) <= 15;

                             -- task 3--
SELECT * FROM khach_hang 
WHERE ((YEAR(CURDATE()) - YEAR(ngay_sinh)) BETWEEN 18 AND 50) AND (dia_chi LIKE '%Đà Nẵng' OR dia_chi LIKE '%Quảng Trị');

                             -- task 4--
SELECT kh.ma_khach_hang, kh.ho_ten , lk.ten_loai_khach, count(kh.ma_khach_hang) AS so_lan_dat_phong
FROM loai_khach lk
JOIN khach_hang kh ON lk.ma_loai_khach = kh.ma_loai_khach
JOIN hop_dong hd ON kh.ma_khach_hang = hd.ma_khach_hang
WHERE lk.ma_loai_khach = 1
GROUP BY kh.ma_khach_hang

                             -- task 5--
                             
                              