create database demo2;
use demo2;
create table users(
id int primary key auto_increment,
`name` varchar(45) not null,
email varchar(45) not null,
address varchar(45) not null
);
 insert into users (`name`, email,address) values('Dong','dongle2606@gmail.com','Da Nang'), ('Han','han2322001@gmail.com','Hoi An'),
 ('An','anprovipgaga','nghe an');
 
 select * from users
 order by `name`;
 
 select * from users where `name` like "%i%";