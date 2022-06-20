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
ifnull(dv.chi_phi_thue,0) + ifnull(so_luong * dvdk.gia,0) AS tong_tien 
FROM loai_khach lk
LEFT JOIN khach_hang kh ON lk.ma_loai_khach = kh.ma_loai_khach
LEFT JOIN hop_dong hd ON kh.ma_khach_hang = hd.ma_khach_hang
LEFT JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
LEFT JOIN hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
LEFT JOIN dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
GROUP BY ma_khach_hang
ORDER BY ma_khach_hang;

                             -- task 6 --
SELECT dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu FROM dich_vu dv
JOIN loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
JOIN hop_dong hd ON dv.ma_dich_vu = hd.ma_dich_vu
GROUP BY ma_dich_vu
HAVING dv.ma_dich_vu NOT IN                             
(SELECT dv.ma_dich_vu FROM dich_vu dv
JOIN loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
JOIN hop_dong hd ON dv.ma_dich_vu = hd.ma_dich_vu
WHERE (MONTH(hd.ngay_lam_hop_dong) BETWEEN 1 AND 3) AND YEAR(hd.ngay_lam_hop_dong) = 2021)
ORDER BY chi_phi_thue DESC; 	

                             -- task 7 --	
SELECT dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten_loai_dich_vu FROM dich_vu dv
JOIN loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
JOIN hop_dong hd ON dv.ma_dich_vu = hd.ma_dich_vu
GROUP BY dv.ma_dich_vu
HAVING dv.ma_dich_vu 
NOT IN
(SELECT dv.ma_dich_vu FROM dich_vu dv
JOIN loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
JOIN hop_dong hd ON dv.ma_dich_vu = hd.ma_dich_vu
WHERE YEAR(hd.ngay_lam_hop_dong) = 2021 );
 
                             -- task 8--
-- cách 1 --                             
SELECT distinct ho_ten FROM khach_hang;
-- cách 2 --
SELECT ho_ten FROM khach_hang
GROUP BY ho_ten;	
-- cách 3 --
SELECT ho_ten FROM khach_hang
UNION
SELECT ho_ten FROM khach_hang;
					
                            -- task 9 --
select month(ngay_lam_hop_dong) as thang, count(hd.ma_khach_hang) as so_luong_khach_hang 
from khach_hang kh
join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
where year(ngay_lam_hop_dong) = 2021 
group by thang
order by thang;			

                           -- task 10 --
SELECT hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc, sum(ifnull(hdct.so_luong,0)) AS so_luong_dich_vu_di_kem FROM hop_dong hd
left JOIN hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
left JOIN dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
GROUP BY hd.ma_hop_dong;

                           -- tash 11 --
SELECT dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, dvdk.gia, dvdk.don_vi, dvdk.trang_thai FROM dich_vu_di_kem dvdk
LEFT JOIN hop_dong_chi_tiet hdct ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
LEFT JOIN hop_dong hd ON hdct.ma_hop_dong = hd.ma_hop_dong
LEFT JOIN khach_hang kh ON hd.ma_khach_hang = kh.ma_khach_hang
LEFT JOIN loai_khach lk ON kh.ma_loai_khach = lk.ma_loai_khach
WHERE lk.ten_loai_khach = 'Diamond' AND (kh.dia_chi LIKE '%Vinh%' OR kh.dia_chi LIKE '%Quãng Ngãi%');

                          -- task 12 --
SELECT hd.ma_hop_dong, nv.ho_ten, kh.ho_ten, kh.so_dien_thoai, dv.ten_dich_vu, sum(hdct.so_luong) 
AS so_luong_dich_vu_di_kem, sum(hd.tien_dat_coc) as tien_dat_coc 	
FROM hop_dong_chi_tiet hdct
JOIN hop_dong hd ON hdct.ma_hop_dong = hd.ma_hop_dong
JOIN nhan_vien nv ON hd.ma_nhan_vien = nv.ma_nhan_vien
JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
JOIN khach_hang kh ON hd.ma_khach_hang = kh.ma_khach_hang
WHERE (MONTH(hd.ngay_lam_hop_dong) BETWEEN 10 AND 12) AND YEAR(hd.ngay_lam_hop_dong) = 2020;

                         -- task 13 --
 SELECT dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, max(hdct.so_luong) as so_luong_dich_vu_di_kem
 FROM khach_hang kh
 JOIN hop_dong hd ON kh.ma_khach_hang = hd.ma_khach_hang
 JOIN hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
 JOIN dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
 group by ma_dich_vu_di_kem
 having so_luong_dich_vu_di_kem >= all (select max(so_luong) from hop_dong_chi_tiet group by ma_hop_dong_chi_tiet);
 
                                -- task 14 -- 
 
 select hd.ma_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, count(hdct.ma_dich_vu_di_kem) as so_lan_su_dung
 from  hop_dong hd
 join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
 join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
 join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
 join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
 group by hdct.ma_dich_vu_di_kem
 having so_lan_su_dung = 1;
 
                               -- task 15 -- 
select count(hd.ma_nhan_vien) as ma_nhan_vien , nv.ho_ten, td.ten_trinh_do, bp.ten_bo_phan, nv.so_dien_thoai, nv.dia_chi from nhan_vien nv
join trinh_do td on nv.ma_trinh_do = td.ma_trinh_do
join bo_phan bp on nv.ma_bo_phan = bp.ma_bo_phan
join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
group by nv.ma_nhan_vien
having count(hd.ma_nhan_vien) <=3;

                              -- task 16 --
update nhan_vien nv
set `check`	= 1 
where nv.ma_nhan_vien in (select * from (										
select nv.ma_nhan_vien From nhan_vien nv
left join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
where nv.ma_nhan_vien not in (
select nv.ma_nhan_vien from nhan_vien nv
right join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien 
group by ma_nhan_vien)) temp
)
;
select ma_nhan_vien, ho_ten from nhan_vien where `check` = 1;

                              -- task 17 --
update khach_hang 
set ma_loai_khach = 1 
where ma_loai_khach in (select * from(
select lk.ma_loai_khach from loai_khach lk
left join khach_hang kh on lk.ma_loai_khach = kh.ma_loai_khach
left join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
where (year(hd.ngay_lam_hop_dong) = 2021) and  (ifnull(dv.chi_phi_thue,0) + ifnull(so_luong * dvdk.gia,0) > 10000000)
group by kh.ma_khach_hang
having lk.ma_loai_khach = 2)temp)
;

							  -- task 18 --
update khach_hang kh
set `check`  = 1
where kh.ma_khach_hang in (select * from(
select kh.ma_khach_hang From khach_hang kh
join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
where year(hd.ngay_lam_hop_dong) < 2021
group by kh.ma_khach_hang)temp)
;
select ma_khach_hang, ho_ten from khach_hang where `check` = 1; 

                              -- task 19 --
update dich_vu_di_kem dvdk 
set dvdk.gia = dvdk.gia * 2 where ma_dich_vu_di_kem in( select * from (
select dvdk.ma_dich_vu_di_kem from hop_dong hd 
join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
where (hdct.so_luong > 10) and year(hd.ngay_lam_hop_dong)  = 2020
group by dvdk.gia) temp)
;

                              -- task 20 -- 
select ma_nhan_vien as id , ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi from nhan_vien
union all 
select ma_khach_hang as id, ho_ten , email, so_dien_thoai, ngay_sinh, dia_chi from khach_hang;

							  -- task 21 --		
create view v_nhan_vien as
select nv.* from nhan_vien nv
join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
where (nv.dia_chi like '%Yên Bái%') and (hd.ngay_lam_hop_dong = 2021-04-25);

                              -- task 22 --
update view v_nhan_vien
set nhan_vien.dia_chi = '%Liên Chiểu%';

                              -- task 23 --
delimiter //
create procedure sp_xoa_khach_hang (in id_khach_hang int )
begin 
   delete from v_nhan_vien 
   where ma_khach_hang = id_khach_hang;
end;
// delimiter ; 

                              -- task 24 --
delimiter // 
create procedure sp_them_moi_hop_dong (in ngay_lam_hop_dong varchar(45),
									   in ngay_ket_thuc varchar(45), 
                                       in tien_dat_coc double,
                                       in ma_nhan_vien int,
                                       in ma_khach_hang int,
                                       in ma_dich_vu int)
begin 
insert into hop_dong(`ngay_lam_hop_dong`, `ngay_ket_thuc`, `tien_dat_coc`, `ma_nhan_vien`, `ma_khach_hang`, `ma_dich_vu`)
values(ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu);
end;
// delimiter ;
call sp_them_moi_hop_dong();