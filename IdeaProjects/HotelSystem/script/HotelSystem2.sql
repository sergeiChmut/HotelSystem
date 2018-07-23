CREATE DATABASE HotelSystem2 ;
USE HotelSystem2;
CREATE TABLE Contacts(id INT PRIMARY KEY AUTO_INCREMENT, email CHAR(20), telephone CHAR(20), country CHAR(20),
city CHAR(20), address CHAR(120), zip CHAR (10));
CREATE TABLE Users(id INT PRIMARY KEY AUTO_INCREMENT, login CHAR(20), password CHAR(20), name CHAR(20),lastname CHAR(20),
role CHAR (15),contact_id INT, FOREIGN KEY (contact_id) REFERENCES Contacts(id) ON DELETE  CASCADE  ON UPDATE CASCADE);
CREATE TABLE Rooms(id INT PRIMARY KEY AUTO_INCREMENT, roomNumber INT,type CHAR(15),bedType INT,
                   price DOUBLE, checkIn DATE,checkOut DATE, description TEXT);
CREATE TABLE Reservation (id INT PRIMARY KEY AUTO_INCREMENT, user_id INT, room_id INT, date DATE,
  FOREIGN KEY (user_id) REFERENCES Users(id) ON DELETE  CASCADE  ON UPDATE CASCADE,
  FOREIGN KEY (room_id) REFERENCES Rooms(id) ON DELETE  CASCADE  ON UPDATE CASCADE);
INSERT INTO Rooms(roomNumber, type, bedType, price, checkIn, checkOut, description)
VALUES (1,'Супер Люкс',3,128.9,'2018-05-05','2018-05-07',
        'Приятный и уютный номер распологается на втором этаже с видом во двор.');
INSERT INTO Rooms(roomNumber, type, bedType, price, checkIn, checkOut, description)
VALUES (2,'Люкс',2,58.9,'2018-06-05','2018-06-10',
        'Уютный номер распологается на втором этаже с видом во двор.');
INSERT INTO Rooms(roomNumber, type, bedType, price, checkIn, checkOut, description)
VALUES (3,'Супер Люкс',2,115.9,'2018-07-05','2018-07-08',
        'Приятный и уютный номер распологается на втором этаже с видом во двор.');
INSERT INTO Rooms(roomNumber, type, bedType, price, checkIn, checkOut, description)
VALUES (4,'Люкс',3,109.9,'2018-06-28','2018-06-30',
        'Уютный номер распологается на втором этаже с видом во двор.');
INSERT INTO Rooms(roomNumber, type, bedType, price, checkIn, checkOut, description)
VALUES (5,'Люкс',1,89.9,'2018-06-30','2018-07-05',
        'Приятный и уютный номер распологается на первом этаже с видом на паркинг');
INSERT INTO Rooms(roomNumber, type, bedType, price, checkIn, checkOut, description)
VALUES (6,'Люкс',1,79.9,'2018-06-25','2018-06-28',
        'Приятный и уютный номер распологается на первом этаже с видом на паркинг');
INSERT INTO Rooms(roomNumber, type, bedType, price, checkIn, checkOut, description)
VALUES (7,'Люкс',1,82.9,'2018-06-25','2018-06-28',
        'Приятный и уютный номер распологается на первом этаже с видом на паркинг');
INSERT INTO Rooms(roomNumber, type, bedType, price, checkIn, checkOut, description)
VALUES (8,'СуперЛюкс',1,89.9,'2018-06-20','2018-06-22',
        'Приятный и уютный номер распологается на первом этаже с видом на паркинг');
SELECT Users.id,Users.login,Users.password,Users.name,Users.lastname,Users.role
FROM Users WHERE Users.login = "Serge";
SELECT Users.id,Users.login,Users.password,Users.name,Users.lastname,Users.role,Contacts.email,Contacts.telephone,
  Contacts.country,Contacts.city,Contacts.address,Contacts.zip
FROM Users,Contacts WHERE Users.contact_id = Contacts.id HAVING Users.id = 1;
INSERT INTO Contacts (email, telephone, country, city, address, zip) VALUES ("QWE@mail.ru","+375291110022",
"Belarus","Minsk","Brestskaya, 18", "220092");
INSERT INTO Users (login, password, name, lastname,role,contact_id) VALUES ("Vasya",
"12345", "Vasya", "Pupkin","user",2);
UPDATE Contacts SET email="ch@tu.by", telephone="291550140", country="Belarus", city="Minsk", address="Magistralnaya, 20-8", zip="220098"
WHERE id=2;
