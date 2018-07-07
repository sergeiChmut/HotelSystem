CREATE DATABASE HotelSystem2 ;
USE HotelSystem;
CREATE TABLE Rooms(roomNumber INT PRIMARY KEY,type CHAR(15),bedType INT,
                   price DOUBLE, checkIn DATE,checkOut DATE, description TEXT);
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