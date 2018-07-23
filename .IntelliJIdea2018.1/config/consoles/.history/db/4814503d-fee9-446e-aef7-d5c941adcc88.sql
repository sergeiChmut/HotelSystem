USE HotelSystem3;
;-- -. . -..- - / . -. - .-. -.--
SELECT * FROM Rooms WHERE bedType=1 AND ("2018-06-10"<=checkOut|"2018-07-05">=checkIn);
;-- -. . -..- - / . -. - .-. -.--
SELECT * FROM Rooms WHERE bedType=1 AND ("2018-06-10"<=checkOut|"2018-06-25">=checkIn);
;-- -. . -..- - / . -. - .-. -.--
SELECT * FROM Rooms WHERE bedType=1 AND ("2018-06-10"<=checkOut|"2018-06-15">=checkIn);
;-- -. . -..- - / . -. - .-. -.--
SELECT * FROM Rooms WHERE bedType=1 AND ("2018-06-10"<=checkOut|"2018-06-12">=checkIn);
;-- -. . -..- - / . -. - .-. -.--
SELECT * FROM Rooms WHERE bedType=1 AND "2018-06-28">=checkOut;
;-- -. . -..- - / . -. - .-. -.--
SELECT * FROM Rooms WHERE bedType=1 AND ("2018-06-10">=checkOut|"2018-07-05"<=checkIn);
;-- -. . -..- - / . -. - .-. -.--
SELECT * FROM Rooms WHERE bedType=1 AND "2018-06-28">checkOut;
;-- -. . -..- - / . -. - .-. -.--
SELECT * FROM Rooms WHERE bedType=1 AND (checkOut<="2018-06-10"|checkIn>="2018-07-05");
;-- -. . -..- - / . -. - .-. -.--
SELECT * FROM Rooms WHERE bedType=1 AND checkOut<"2018-06-28";
;-- -. . -..- - / . -. - .-. -.--
SELECT * FROM Rooms WHERE bedType=1 AND (checkOut<="2018-06-28"|checkIn>="2018-07-05");
;-- -. . -..- - / . -. - .-. -.--
SELECT * FROM Rooms WHERE bedType=1 AND (checkOut<="2018-07-28"|checkIn>="2018-07-30");
;-- -. . -..- - / . -. - .-. -.--
SELECT * FROM Rooms WHERE bedType=1 AND ((checkOut<="2018-07-28")|(checkIn>="2018-07-30"));
;-- -. . -..- - / . -. - .-. -.--
SELECT * FROM Rooms WHERE bedType=1 AND ((checkOut<="2018-06-28")|(checkIn>="2018-07-05"));
;-- -. . -..- - / . -. - .-. -.--
SELECT * FROM Rooms WHERE bedType=1 AND ((checkOut<="2018-06-25")|(checkIn>="2018-07-05"));
;-- -. . -..- - / . -. - .-. -.--
SELECT * from rooms;
;-- -. . -..- - / . -. - .-. -.--
select * from room;
;-- -. . -..- - / . -. - .-. -.--
USE HotelSystem;
;-- -. . -..- - / . -. - .-. -.--
select * from rooms;
;-- -. . -..- - / . -. - .-. -.--
CREATE TABLE users(id INT AUTO_INCREMENT PRIMARY KEY , login CHAR(20), password CHAR(20), name CHAR(20), lastname CHAR(20), country CHAR(20), address CHAR(20),
        city CHAR(20), zip CHAR(20), telephone CHAR(20));
;-- -. . -..- - / . -. - .-. -.--
select * from users;
;-- -. . -..- - / . -. - .-. -.--
create database proba;
;-- -. . -..- - / . -. - .-. -.--
create table user (id INT AUTO_INCREMENT PRIMARY KEY , login CHAR(20), password CHAR(20), phone CHAR(20));
;-- -. . -..- - / . -. - .-. -.--
create table customer (phone char(20), name CHAR(20), lastname char(20));
;-- -. . -..- - / . -. - .-. -.--
delete customer;
;-- -. . -..- - / . -. - .-. -.--
create table customer (phone char(20) PRIMARY KEY , name CHAR(20), lastname char(20));
;-- -. . -..- - / . -. - .-. -.--
drop table user;
;-- -. . -..- - / . -. - .-. -.--
create table user (id INT AUTO_INCREMENT PRIMARY KEY , login CHAR(20), password CHAR(20), phone CHAR(20) PRIMARY KEY );
;-- -. . -..- - / . -. - .-. -.--
create table customer (id INT AUTO_INCREMENT,phone char(20) PRIMARY KEY , name CHAR(20), lastname char(20));
;-- -. . -..- - / . -. - .-. -.--
create table user (id INT AUTO_INCREMENT, login CHAR(20), password CHAR(20), phone CHAR(20), PRIMARY KEY(id,phone) );
;-- -. . -..- - / . -. - .-. -.--
create table customer (id INT AUTO_INCREMENT primary key ,phone char(20), name CHAR(20), lastname char(20));
;-- -. . -..- - / . -. - .-. -.--
alter table customer add constraint fk1 foreign key (phone) references user(phone) on delete cascade;
;-- -. . -..- - / . -. - .-. -.--
drop database proba;
;-- -. . -..- - / . -. - .-. -.--
create database if not exists proba;
;-- -. . -..- - / . -. - .-. -.--
use proba;
;-- -. . -..- - / . -. - .-. -.--
create table user (id INT AUTO_INCREMENT, login CHAR(20), password CHAR(20), phone CHAR(20),PRIMARY KEY (phone));
;-- -. . -..- - / . -. - .-. -.--
create table user (id INT AUTO_INCREMENT, login CHAR(20), password CHAR(20), phone CHAR(20),PRIMARY KEY (id,phone));
;-- -. . -..- - / . -. - .-. -.--
create table customer (id INT AUTO_INCREMENT ,phone CHAR(20), name CHAR(20), lastname CHAR(20),PRIMARY KEY (id,phone),CONSTRAINT fk1 FOREIGN KEY (phone) REFERENCES user(phone) ON DELETE CASCADE);
;-- -. . -..- - / . -. - .-. -.--
drop table customer;
;-- -. . -..- - / . -. - .-. -.--
create table customer (id INT AUTO_INCREMENT ,phone CHAR(20), name CHAR(20), lastname CHAR(20),PRIMARY KEY (id,phone));
;-- -. . -..- - / . -. - .-. -.--
create index phone on customer (phone);
;-- -. . -..- - / . -. - .-. -.--
create index phone2 on user (phone);
;-- -. . -..- - / . -. - .-. -.--
ALTER TABLE customer ADD CONSTRAINT fk1 FOREIGN KEY (phone) REFERENCES user(phone) ON DELETE CASCADE;
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO user (login, password, phone) values ("serge","sdas","296242712");
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO user (login, password, phone) values ("serge","sdas","296242715");
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO customer (phone, name, lastname) values ("296242712","Сергей","Чмут");
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO customer (phone, name, lastname) values ("296242715","Сергей","Пупкин");
;-- -. . -..- - / . -. - .-. -.--
DELETE FROM user WHERE id=1;
;-- -. . -..- - / . -. - .-. -.--
SELECT * FROM user;
;-- -. . -..- - / . -. - .-. -.--
SELECT * FROM customer;
;-- -. . -..- - / . -. - .-. -.--
create database if not exists proba2;
;-- -. . -..- - / . -. - .-. -.--
create table country (id INT PRIMARY KEY AUTO_INCREMENT, name CHAR(20));
;-- -. . -..- - / . -. - .-. -.--
create table city (id INT PRIMARY KEY AUTO_INCREMENT, name CHAR(20), country_id INT , FOREIGN KEY (country_id) REFERENCES country(id) ON DELETE CASCADE ON UPDATE CASCADE);
;-- -. . -..- - / . -. - .-. -.--
create table address (id INT PRIMARY KEY AUTO_INCREMENT, street CHAR(20), num INT, numRoom INT, city_id ,FOREIGN KEY  (city_id) REFERENCES  city(id) ON DELETE  CASCADE  ON UPDATE CASCADE );
;-- -. . -..- - / . -. - .-. -.--
create table address (id INT PRIMARY KEY AUTO_INCREMENT, street CHAR(20), num INT, numRoom INT, city_id INT,FOREIGN KEY  (city_id) REFERENCES  city(id) ON DELETE  CASCADE  ON UPDATE CASCADE );
;-- -. . -..- - / . -. - .-. -.--
create table user (id INT PRIMARY KEY AUTO_INCREMENT, name CHAR(20), address_id INT, FOREIGN KEY (address_id) REFERENCES address(id) ON DELETE CASCADE ON UPDATE CASCADE);
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO country(name) VALUES ("Беларусь");
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO country(name) VALUES ("США");
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO country(name) VALUES ("Россия");
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO city(name,country_id) VALUES ("Минск",1);
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO city(name,country_id) VALUES ("Витебск",2);
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO city(name,country_id) VALUES ("Гродно",3);
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO address (street, num, numRoom, city_id) VALUES ("Победителей", 25, 8, 1);
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO address (street, num, numRoom, city_id) VALUES ("Победителей", 26, 8, 1);
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO address (street, num, numRoom, city_id) VALUES ("Победителей", 30, 5, 1);
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO address (street, num, numRoom, city_id) VALUES ("Космонавтов", 25, 8, 1);
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO address (street, num, numRoom, city_id) VALUES ("Победителей", 25, 8, 2);
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO address (street, num, numRoom, city_id) VALUES ("Победителей", 25, 8, 3);
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO user (name, address_id) VALUES ("Serge", 1);
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO user (name, address_id) VALUES ("Petya", 2);
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO user (name, address_id) VALUES ("VAsya", 5);
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO user (name, address_id) VALUES ("Sveta", 6);
;-- -. . -..- - / . -. - .-. -.--
SELECT user.name,address.street,address.num,address.numRoom,city.name,country.name FROM user,address,city,country JOIN city c on country.id = c.country_id;
;-- -. . -..- - / . -. - .-. -.--
SELECT user.name,address.street,address.num,address.numRoom,city.name,country.name FROM user,address,city,country JOIN city c on country.id = c.country_id WHERE user.name = "Serge";
;-- -. . -..- - / . -. - .-. -.--
SELECT user.name,address.street,address.num,address.numRoom,city.name,country.name
FROM user,address,city,country
        WHERE user.address_id = address.id AND country_id = country.id AND city_id = city.id HAVING user.name = "Serge";
;-- -. . -..- - / . -. - .-. -.--
DELETE FROM user WHERE name = "Serge";
;-- -. . -..- - / . -. - .-. -.--
UPDATE user SET city.name = "Гродно" WHERE name = "Petya";
;-- -. . -..- - / . -. - .-. -.--
UPDATE user SET address_id = 6 WHERE user.name = "Petya";
;-- -. . -..- - / . -. - .-. -.--
SELECT user.name,address.street,address.num,address.numRoom,city.name,country.name
FROM user,address,city,country
WHERE user.address_id = address.id AND country_id = country.id AND city_id = city.id HAVING user.name = "Petya";
;-- -. . -..- - / . -. - .-. -.--
use proba2;
;-- -. . -..- - / . -. - .-. -.--
drop database HotelSystem2;
;-- -. . -..- - / . -. - .-. -.--
CREATE TABLE Users(id INT PRIMARY KEY AUTO_INCREMENT, login CHAR(20), password CHAR(20), name CHAR(20),lastname CHAR(20),
                   contact_id INT, FOREIGN KEY (contact_id) REFERENCES Contacts(id) ON DELETE  CASCADE  ON UPDATE CASCADE);
;-- -. . -..- - / . -. - .-. -.--
SELECT Users.id,Users.login,Users.password,Users.name,Users.lastname,Contacts.email,Contacts.telephone,
  Contacts.country,Contacts.city,Contacts.address,Contacts.zip   
FROM Users,Contacts WHERE User.contacts_id = Contacts.id HAVING User.login = "Serge";
;-- -. . -..- - / . -. - .-. -.--
SELECT Users.id,Users.login,Users.password,Users.name,Users.lastname,Contacts.email,Contacts.telephone,
  Contacts.country,Contacts.city,Contacts.address,Contacts.zip
FROM Users,Contacts WHERE User.contact_id = Contacts.id HAVING User.login = "Serge";
;-- -. . -..- - / . -. - .-. -.--
SELECT Users.id,Users.login,Users.password,Users.name,Users.lastname,Contacts.email,Contacts.telephone,
  Contacts.country,Contacts.city,Contacts.address,Contacts.zip
FROM Users,Contacts WHERE Users.contact_id = Contacts.id HAVING User.login = "Serge";
;-- -. . -..- - / . -. - .-. -.--
SELECT Users.id,Users.login,Users.password,Users.name,Users.lastname,Contacts.email,Contacts.telephone,
  Contacts.country,Contacts.city,Contacts.address,Contacts.zip
FROM Users,Contacts WHERE Users.contact_id = Contacts.id HAVING Users.login = "Serge";
;-- -. . -..- - / . -. - .-. -.--
SELECT Users.id,Users.login,Users.password,Users.name,Users.lastname,Contacts.email,Contacts.telephone,
  Contacts.country,Contacts.city,Contacts.address,Contacts.zip
FROM Users,Contacts WHERE Users.contact_id = Contacts.id HAVING Users.id = 1;
;-- -. . -..- - / . -. - .-. -.--
SELECT Users.id,Users.login,Users.password,Users.name,Users.lastname
FROM Users WHERE Users.login = "Serge";
;-- -. . -..- - / . -. - .-. -.--
DROP DATABASE HotelSystem2;
;-- -. . -..- - / . -. - .-. -.--
CREATE DATABASE HotelSystem2;
;-- -. . -..- - / . -. - .-. -.--
USE HotelSystem2;
;-- -. . -..- - / . -. - .-. -.--
CREATE TABLE Contacts(id INT PRIMARY KEY AUTO_INCREMENT, email CHAR(20), telephone CHAR(20), country CHAR(20),
                      city CHAR(20), address CHAR(120), zip CHAR (10));
;-- -. . -..- - / . -. - .-. -.--
CREATE TABLE Users(id INT PRIMARY KEY AUTO_INCREMENT, login CHAR(20), password CHAR(20), name CHAR(20),lastname CHAR(20),
                   role CHAR (15),contact_id INT, FOREIGN KEY (contact_id) REFERENCES Contacts(id) ON DELETE  CASCADE  ON UPDATE CASCADE);
;-- -. . -..- - / . -. - .-. -.--
CREATE TABLE Rooms(id INT PRIMARY KEY AUTO_INCREMENT, roomNumber INT,type CHAR(15),bedType INT,
                   price DOUBLE, checkIn DATE,checkOut DATE, description TEXT);
;-- -. . -..- - / . -. - .-. -.--
CREATE TABLE Reservation (id INT PRIMARY KEY AUTO_INCREMENT, user_id INT, room_id INT, date DATE,
  FOREIGN KEY (user_id) REFERENCES Users(id) ON DELETE  CASCADE  ON UPDATE CASCADE,
  FOREIGN KEY (room_id) REFERENCES Rooms(id) ON DELETE  CASCADE  ON UPDATE CASCADE);
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO Rooms(roomNumber, type, bedType, price, checkIn, checkOut, description)
VALUES (1,'Супер Люкс',3,128.9,'2018-05-05','2018-05-07',
        'Приятный и уютный номер распологается на втором этаже с видом во двор.');
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO Rooms(roomNumber, type, bedType, price, checkIn, checkOut, description)
VALUES (2,'Люкс',2,58.9,'2018-06-05','2018-06-10',
        'Уютный номер распологается на втором этаже с видом во двор.');
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO Rooms(roomNumber, type, bedType, price, checkIn, checkOut, description)
VALUES (3,'Супер Люкс',2,115.9,'2018-07-05','2018-07-08',
        'Приятный и уютный номер распологается на втором этаже с видом во двор.');
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO Rooms(roomNumber, type, bedType, price, checkIn, checkOut, description)
VALUES (4,'Люкс',3,109.9,'2018-06-28','2018-06-30',
        'Уютный номер распологается на втором этаже с видом во двор.');
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO Rooms(roomNumber, type, bedType, price, checkIn, checkOut, description)
VALUES (5,'Люкс',1,89.9,'2018-06-30','2018-07-05',
        'Приятный и уютный номер распологается на первом этаже с видом на паркинг');
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO Rooms(roomNumber, type, bedType, price, checkIn, checkOut, description)
VALUES (6,'Люкс',1,79.9,'2018-06-25','2018-06-28',
        'Приятный и уютный номер распологается на первом этаже с видом на паркинг');
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO Rooms(roomNumber, type, bedType, price, checkIn, checkOut, description)
VALUES (7,'Люкс',1,82.9,'2018-06-25','2018-06-28',
        'Приятный и уютный номер распологается на первом этаже с видом на паркинг');
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO Rooms(roomNumber, type, bedType, price, checkIn, checkOut, description)
VALUES (8,'СуперЛюкс',1,89.9,'2018-06-20','2018-06-22',
        'Приятный и уютный номер распологается на первом этаже с видом на паркинг');
;-- -. . -..- - / . -. - .-. -.--
SELECT Users.id,Users.login,Users.password,Users.name,Users.lastname,Users.role
FROM Users WHERE Users.login = "Serge";
;-- -. . -..- - / . -. - .-. -.--
SELECT Users.id,Users.login,Users.password,Users.name,Users.lastname,Users.role,Contacts.email,Contacts.telephone,
  Contacts.country,Contacts.city,Contacts.address,Contacts.zip
FROM Users,Contacts WHERE Users.contact_id = Contacts.id HAVING Users.id = 1;
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO Users (login, password, name, lastname,role, email, telephone, country, city, address, zip) VALUES ("Vasya", 
"12345", "Vasya", "Pupkin","user", "QWE@mail.ru","+375291110022",
  "Belarus","Minsk","Brestskaya, 18", "220092");
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO Users (login, password, name, lastname,role, telephone, country, city, address, zip) VALUES ("Vasya",
"12345", "Vasya", "Pupkin","user","+375291110022",
  "Belarus","Minsk","Brestskaya, 18", "220092");
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO Contacts (email, telephone, country, city, address, zip) VALUES ("QWE@mail.ru","+375291110022",
"Belarus","Minsk","Brestskaya, 18", "220092");
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO Users (login, password, name, lastname,role,contact_id) VALUES ("Vasya",
"12345", "Vasya", "Pupkin","user",2);
;-- -. . -..- - / . -. - .-. -.--
SELECT Users.id,Users.login,Users.password,Users.name,Users.lastname,Users.role,Contacts.email,Contacts.telephone,
  Contacts.country,Contacts.city,Contacts.address,Contacts.zip
FROM Users,Contacts WHERE Users.contact_id = Contacts.id HAVING Users.id = 2;
;-- -. . -..- - / . -. - .-. -.--
UPDATE Contacts SET email="ch@tu.by", telephone="291550140", country="Belarus", city="Minsk", address="Magistralnaya, 20-8", zip="220098"
WHERE id=2;
;-- -. . -..- - / . -. - .-. -.--
SELECT contact_id FROM Users WHERE id=2;
;-- -. . -..- - / . -. - .-. -.--
SELECT contact_id FROM Users WHERE id=3;
;-- -. . -..- - / . -. - .-. -.--
SELECT Users.id,Users.login,Users.password,Users.name,Users.lastname,Users.role,Contacts.email,Contacts.telephone,
  Contacts.country,Contacts.city,Contacts.address,Contacts.zip
FROM Users,Contacts WHERE Users.contact_id = Contacts.id HAVING Users.id = 3;
;-- -. . -..- - / . -. - .-. -.--
INSERT INTO Reservation (user_id, room_id, date) VALUES (3,7,now());
;-- -. . -..- - / . -. - .-. -.--
use hotelsystem2;
;-- -. . -..- - / . -. - .-. -.--
ALTER TABLE Users AUTO_INCREMENT=0;
;-- -. . -..- - / . -. - .-. -.--
ALTER TABLE Contacts AUTO_INCREMENT=0;
;-- -. . -..- - / . -. - .-. -.--
SELECT * FROM Reservation WHERE date>="2018-07-15" AND date<="2018-07-16";
;-- -. . -..- - / . -. - .-. -.--
SELECT * FROM Reservation WHERE date>="2018-07-16" AND date<="2018-07-16";
;-- -. . -..- - / . -. - .-. -.--
SELECT * FROM Reservation WHERE date>="2018-07-18" AND date<="2018-07-18";