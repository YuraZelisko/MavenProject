//
//drop database if exists antivirus;
//create database antivirus;
//use antivirus;
//
//create table Product(
//id int primary key auto_increment,
//name varchar(30),
//quantity int,
//first_price double,
//renewel_price double,
//duration_years int,
//film_name varchar(45)
//);
//
//
//
//
//create table User(
//id int primary key auto_increment,
//name varchar(30),
//email varchar(65) unique,
//password varchar(45),
//phone varchar(13),
//adress varchar(100),
//additional_Information varchar(200)
//);
//
//
//
//create table Orders(
//id int primary key auto_increment,
//name varchar(30),
//price double,
//date_sell date
//);