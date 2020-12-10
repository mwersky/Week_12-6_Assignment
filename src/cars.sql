create database if not exists cars;
use cars;
drop table if exists customers;
drop table if exists cars;
drop table if exists customer_cars;

create table customers(
	id int(10) not null auto_increment,
    first_name varchar(48) not null,
    last_name varchar(48) not null,
    primary key(id)
);
create table cars(
	id int(10) not null auto_increment,
    model varchar(48) not null,
    make varchar(48) not null,
    model_year year not null,
    price double not null,
    primary key(id)
);
create table customer_cars(
	cust_id int(10) not null,
    car_id int(10) not null,
    primary key(cust_id,car_id),
    foreign key (cust_id) references customers(id),
    foreign key (car_id) references cars(id)
);