CREATE DATABASE HotelSystem;
USE HotelSystem;
CREATE TABLE Rooms(roomNumber INT PRIMARY KEY,type CHAR(15),bedType CHAR(30),
  price DOUBLE, roomLock DATE, description TEXT);
INSERT INTO Rooms(roomNumber, type, bedType, price, roomLock, description)
 VALUES (1,'Супер Люкс','Трехместный',128.9,'2018-05-05',
         'Приятный и уютный номер распологается на втором этаже с видом во двор.');
INSERT INTO Rooms(roomNumber, type, bedType, price, roomLock, description)
VALUES (2,'Люкс','Двуместный',58.9,'2018-06-05',
        'Уютный номер распологается на втором этаже с видом во двор.');
INSERT INTO Rooms(roomNumber, type, bedType, price, roomLock, description)
VALUES (3,'Супер Люкс','Двуместный',115.9,'2018-07-05',
        'Приятный и уютный номер распологается на втором этаже с видом во двор.');
INSERT INTO Rooms(roomNumber, type, bedType, price, roomLock, description)
VALUES (4,'Люкс','Трехместный',109.9,'2018-06-28',
        'Уютный номер распологается на втором этаже с видом во двор.');
INSERT INTO Rooms(roomNumber, type, bedType, price, roomLock, description)
VALUES (5,'Люкс','Одноместный',89.9,'2018-06-30',
        'Приятный и уютный номер распологается на первом этаже с видом на паркинг');
INSERT INTO Rooms(roomNumber, type, bedType, price, roomLock, description)
VALUES (6,'Люкс','Одноместный',79.9,'2018-06-25',
        'Приятный и уютный номер распологается на первом этаже с видом на паркинг');
INSERT INTO Rooms(roomNumber, type, bedType, price, roomLock, description)
VALUES (7,'Люкс','Одноместный',82.9,'2018-06-25',
        'Приятный и уютный номер распологается на первом этаже с видом на паркинг');
INSERT INTO Rooms(roomNumber, type, bedType, price, roomLock, description)
VALUES (8,'СуперЛюкс','Одноместный',89.9,'2018-06-20',
        'Приятный и уютный номер распологается на первом этаже с видом на паркинг');
