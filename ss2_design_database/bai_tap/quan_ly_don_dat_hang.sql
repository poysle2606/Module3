CREATE DATABASE quan_ly_don_dat_hang;

use quan_ly_don_dat_hang;

CREATE TABLE phieu_xuat(
so_px     INT AUTO_INCREMENT PRIMARY KEY,
ngay_xuat DATE);

CREATE TABLE vat_tu(
ma_vtu  INT AUTO_INCREMENT PRIMARY KEY,
ten_vtu VARCHAR(50) NOT NULL);

CREATE TABLE chi_tiet_phieu_xuat(
so_px   INT,
ma_vtu  INT,
dg_xuat INT,
sl_xuat INT,
PRIMARY KEY(so_px, ma_vtu),
FOREIGN KEY (so_px) REFERENCES phieu_xuat(so_px),
FOREIGN KEY (ma_vtu) REFERENCES vat_tu(ma_vtu));

CREATE TABLE phieu_nhap(
so_pn INT AUTO_INCREMENT PRIMARY KEY,
ngay_nhap DATE);

CREATE TABLE chi_tiet_phieu_nhap(
ma_vtu  INT,
so_pn INT,
dg_nhap INT,
sl_nhap INT,
PRIMARY KEY(ma_vtu, so_pn),
FOREIGN KEY (ma_vtu) REFERENCES vat_tu(ma_vtu),
FOREIGN KEY (so_pn) REFERENCES phieu_nhap(so_pn)) ;

CREATE TABLE nha_cc(
ma_ncc INT PRIMARY KEY,
ten_ncc VARCHAR(20),
dia_chi VARCHAR(50)
);

CREATE TABLE don_dh(
so_dh INT PRIMARY KEY,
ngay_dh DATE,
ma_ncc INT,
foreign key(ma_ncc) references nha_cc(ma_ncc)
);

CREATE TABLE chi_tiet_dat_don_hang(
ma_vtu  INT,
so_dh   INT,
PRIMARY KEY (ma_vtu, so_dh),
FOREIGN KEY (ma_vtu) REFERENCES vat_tu(ma_vtu),
FOREIGN KEY (so_dh) REFERENCES don_dh(so_dh));

create table sdt_nha_cc(
ma_ncc int not null,
sdt varchar(10) not null,
foreign key(ma_ncc) references nha_cc (ma_ncc)
);