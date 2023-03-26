drop database if exists FilterListenerAjax_practice;
create database FilterListenerAjax_practice;
use FilterListenerAjax_practice;
create table users(
    id int auto_increment primary key ,
    username varchar(12) check (length(username)>=6) unique ,
    password varchar(12) check (length(password)>=6)
);

insert into users values (null,'testac01','password');
insert into users values (null,'testac02','password');

create table  tb_brand(
                          id int primary key auto_increment,
                          brand_name varchar(20),
                          company_name varchar(20),
                          ordered int,
                          description varchar(100),
                          status int
);

insert into tb_brand(id,brand_name,company_name,ordered,description,status)
values (1,'Meta','MetaSoft',20,'So soft..',1),
       (2,'Doo','Doodle',2,'Just Doo it..',0),
       (3,'MaMa','AaLiMaMa',10,'Ur Best Choice..',1);



select * from users;
select * from tb_brand;