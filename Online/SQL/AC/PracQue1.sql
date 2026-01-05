CREATE DATABASE IF NOT EXISTS OLearningFromAC1;
USE OLearningFromAC1;

CREATE TABLE IF NOT EXISTS Que1employee(ID INT PRIMARY KEY, NAME VARCHAR(50) NOT NULL, SALARY INT);

INSERT INTO Que1employee VALUES(1,"Adam",25000);
insert into Que1employee values(2,"Bob",30000),(3,"Casey",40000);

SELECT * FROM Que1employee;
#drop table Que1employee;