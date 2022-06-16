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
GROUP BY kh.ma_khach_hang;

                             -- task 5--
SELECT kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, 
ifnull(dv.chi_phi_thue + hdct.so_luong * dvdk.gia,0) AS tong_tien 
FROM loai_khach lk
left JOIN khach_hang kh ON lk.ma_loai_khach = kh.ma_loai_khach
left JOIN hop_dong hd ON kh.ma_khach_hang = hd.ma_khach_hang
left JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
left JOIN hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
left JOIN dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
GROUP BY ma_khach_hang
ORDER BY ma_khach_hang;

                             -- task 6 --
SELECT dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu FROM dich_vu dv
JOIN loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
JOIN hop_dong hd ON dv.ma_dich_vu = hd.ma_dich_vu
group by ma_dich_vu
having dv.ma_dich_vu NOT IN                             
(SELECT dv.ma_dich_vu FROM dich_vu dv
JOIN loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
JOIN hop_dong hd ON dv.ma_dich_vu = hd.ma_dich_vu
WHERE (MONTH(hd.ngay_lam_hop_dong) BETWEEN 1 AND 3) AND YEAR(hd.ngay_lam_hop_dong) = 2021)
ORDER BY chi_phi_thue DESC; 	

                             -- task 7 --	

                             -- task 8--
-- cách 1 --                             
SELECT distinct ho_ten FROM khach_hang;
-- cách 2 --
SELECT ho_ten FROM khach_hang
GROUP BY ho_ten;							
                              