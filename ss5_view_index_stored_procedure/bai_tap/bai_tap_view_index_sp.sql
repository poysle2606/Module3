DROP DATABASE IF EXISTS demo;

CREATE DATABASE demo;

USE demo;

CREATE TABLE products(
id INT PRIMARY KEY AUTO_INCREMENT,
product_code INT, 
product_name VARCHAR(45),
product_price DOUBLE,
product_amount INT,
product_description VARCHAR(45),
product_status VARCHAR(45)
);

INSERT INTO products(product_code, product_name, product_price, product_amount, product_description, product_status) 
VALUES  (1111, 'MILK', 15000, 10, 'white color', 'new'), 
		(2222, 'Watermelon', 7000, 20, 'green', 'fruit'),
		(3333, 'Tea', 2000, 30,'green', 'new');
        
alter table products add unique(product_code);

create index create_index_product on products(product_name, product_price); 

explain select * from products where product_code;

create view create_review_product as 
select product_code, product_name, product_price, product_status from products;
select * from create_review_product;

-- Tiến hành sửa đổi view
update create_review_product
set product_price = 1234
where product_code = 2222;

-- Tiến hành xoá view
drop view create_review_product;

   -- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter //
create procedure get_all_product()
begin 
 select * from products;
 end //
delimiter ;

-- Tạo store procedure thêm một sản phẩm mới
delimiter //
create procedure add_product( in product_code INT, in product_name varchar(45), in product_price double,
in product_amount int, in product_description varchar(45), in product_status varchar(45))
begin 
INSERT INTO products(`product_code`, `product_name`, `product_price`, `product_amount`, `product_description`, `product_status`)
VALUES (product_code, product_name, product_price, product_amount, product_description, product_status);
 end ;
// delimiter ;
call add_product(5555, 'mỳ hảo hảo', 3000, 20, 'chua cay', 'new');

-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter //
create procedure update_product( 
 in id_product int,
 in product_code INT, 
 in produccct_name varchar(45),
 in product_price double,
 in product_amount int,
 in product_description varchar(45), 
 in product_status varchar(45))
begin 
update  products 
set `product_code` = product_code,
`product_name` = produccct_name ,
`product_price` = product_price,
`product_amount` = product_amount,
`product_description` = product_description,
`product_status` = product_status 
where `id` = id_product;
 end 
// delimiter ;

 call update_product(1,3, "dong ngu",10,10,"dong ga", "moi");
 call procedure_product;
 
 delimiter //
create procedure delete_product( in id_delete int)
begin
	delete from products
	where `id` = id_delete;
end;
// delimiter ;

call delete_product(2);