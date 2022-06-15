use case_study;

SELECT * FROM nhan_vien 
WHERE(ho_ten LIKE 'H%' OR ho_ten LIKE 'K%' OR ho_ten LIKE 'T%' ) AND char_length(ho_ten) <= 15;

SELECT * FROM khach_hang 
WHERE ((YEAR(CURDATE()) - YEAR(ngay_sinh)) BETWEEN 18 and 50) AND (dia_chi LIKE '%Đà Nẵng' OR dia_chi LIKE '%Quảng Trị');