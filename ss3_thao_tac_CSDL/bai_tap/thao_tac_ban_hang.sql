	use quan_ly_ban_hang;
    
    insert into customer(cus_name, cus_age) 
    values ('Minh Quan', '10') , ('Ngoc Oanh', '20'), ('Hong Ha', '50');
    
    insert into `order`(cus_id, or_date, or_total_price)
    values (1, '2006-3-21', Null), (2, '2006-3-23', Null) , (1, '2006-3-16', Null);
    
    insert into product(pro_name, pro_price) 
    values ('May Giat', 3) ,('Tu Lanh', 5), ('Dieu Hoa', 7), ('Quat', 1), ('Bep Dien', 2);
    
    insert into order_detail(or_id, pro_id, od_qty) 
    values (1,1,'3'), (1,3,'7'), (1,4,'2'), (2,1,'1'), (3,1,'8'), (2,5,'4'), (2,3,'3');
    
    -- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
    
    SELECT or_id, or_date, or_total_price AS price 
    FROM `order`;
   
   -- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
   
   SELECT c.cus_name, p.pro_name
   FROM customer c
   JOIN `order` o ON o.cus_id = c.cus_id
   JOIN order_detail od ON od.or_id = o.or_id 
   JOIN product p ON p.pro_id = od.pro_id;
   
   -- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào

   SELECT c.*, count(o.or_id) AS so_lan_mua_hang
   FROM customer c 
   LEFT JOIN `order` o ON c.cus_id = o.cus_id
   GROUP BY o.or_id HAVING so_lan_mua_hang = 0;
   
   -- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn
   
   SELECT o.or_id, o.or_date, sum(p.pro_price * od.od_qty) AS tong_tien
   FROM product p
   JOIN order_detail od ON od.pro_id = p.pro_id
   JOIN `order` o ON o.or_id = od.or_id
   GROUP BY or_id 
   