CREATE DATABASE quan_ly_ban_hang;

use quan_ly_ban_hang;

CREATE TABLE customer(
cus_id   INT         AUTO_INCREMENT PRIMARY KEY,
cus_name VARCHAR(30) NOT NULL,
cus_age  DATE);

CREATE TABLE `order`(
or_id          INT AUTO_INCREMENT PRIMARY KEY,
cus_id         INT,
or_date        DATE NOT NULL,
or_total_price INT NOT NULL,
FOREIGN KEY (cus_id) REFERENCES customer(cus_id));

CREATE TABLE product(
pro_id INT AUTO_INCREMENT PRIMARY KEY,
pro_name VARCHAR(50) NOT NULL,
pro_price INT NOT NULL); 

CREATE TABLE order_detail(
or_id  INT ,
pro_id INT ,
od_qty VARCHAR(20) NOT NULL,
PRIMARY KEY (or_id, pro_id),
FOREIGN KEY (or_id) REFERENCES `order`(or_id),
FOREIGN KEY (pro_id) REFERENCES product(pro_id));	