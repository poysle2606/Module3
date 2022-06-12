-- CREATE DATABASE `bai_tap1`
CREATE TABLE `bai_tap1`.class(
`id` INT NOT NULL,
`name` VARCHAR(45) NULL,
PRIMARY KEY (`id`) );
CREATE TABLE `bai_tap1`.teacher(
`id` INT NOT NULL,
`name` VARCHAR(45) NULL,
`age` INT NOT NULL,
`country` VARCHAR(45) NULL,
PRIMARY KEY(`id`));