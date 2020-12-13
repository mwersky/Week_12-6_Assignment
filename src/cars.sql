create database if not exists cars;
use cars;
drop table if exists sales;
drop table if exists customers;
drop table if exists cars;

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
create table sales(
	id int(10) not null auto_increment,
	cust_id int(10) not null,
    car_id int(10) not null,
    sales_date datetime not null,
    primary key(id),
    foreign key (cust_id) references customers(id),
    foreign key (car_id) references cars(id)
);

#DELETE BELOW LINE TO START WITH EMPTY TABLE

INSERT INTO cars (model,make,model_year,price) VALUES
('X1','BMW','2020','34900'),
('X2','BMW','2020','41900'),
('X3','BMW','2020','44900'),
('X4','BMW','2020','60900'),
('X5','BMW','2020','65900'),
('X6','BMW','2020','68900'),
('X7','BMW','2020','73900');

INSERT INTO customers (first_name, last_name) VALUES ('Jesse','Hepp'),
('Leigha','Heaton'),
('Conchita','Crittendon'),
('Kenia','Polinsky'),
('Gloria','Stuck'),
('Randy','Masone'),
('Lilla','Dejarnette'),
('Caitlin','Amesquita'),
('Ulysses','Coughlin'),
('Kimiko','Sealey'),
('Mozella','Tatem'),
('Ian','Loveridge'),
('Anderson','Rippey'),
('Nam','Lovering'),
('Buster','Sherwin'),
('Susannah','Ruggles'),
('Amado','Reddington'),
('Vance','Lawhon'),
('Juanita','Ridley'),
('Shara','Gaudreau'),
('Mariette','Guilliams'),
('Sammy','Davey'),
('Sena','Loudin'),
('Dino','Hansen'),
('Hai','Rufus'),
('Mathew','Moors'),
('Garnet','Ingersoll'),
('Devin','Shealey'),
('Teodoro','Erazo'),
('Augustina','Force'),
('Hunter','Cathey'),
('Lowell','Hilliker'),
('Wilfred','McConnaughy'),
('Rosaura','Skolnick'),
('Asley','Bilodeau'),
('Delcie','Boozer'),
('Lance','Weldon'),
('Kerstin','Keniston'),
('Moriah','Sasser'),
('Rene','Cotton'),
('Cyrstal','Uriarte'),
('William','Payson'),
('Jamar','Stocker'),
('Chelsea','Ledger'),
('Pete','Schade'),
('Augustus','Galbraith'),
('Bernie','Steely'),
('Paulita','Krein'),
('Evan','Puffer'),
('Timothy','Riehle'),
('Minh','Culwell'),
('Gordon','Raggs'),
('Adam','Scoby'),
('Chance','Tingle'),
('Sterling','Board'),
('Katerine','Westerberg'),
('Jeramy','Hammers'),
('Major','Parlier'),
('Renato','Florentino'),
('Gil','Vanhorne'),
('Rocco','Ater'),
('Junko','Santoyo'),
('Lawerence','Pebley'),
('Lionel','Laclair'),
('Sergio','Madonia'),
('Lore','Shankle'),
('Samuel','Lagasse'),
('Thurman','Mortensen'),
('Rickey','Looney'),
('Royal','Zackery'),
('Genevive','Starkweather'),
('Dean','Obey'),
('Leroy','Gilchrest'),
('Loren','Wines'),
('Kent','Brazzell'),
('Desire','Rappa'),
('Zella','Nakayama'),
('Glenn','Ruge'),
('Jerrold','Lefebvre'),
('Dario','Kenna');




