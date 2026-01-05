#SHOWING SOME TABLE RELATED QUERIES

CREATE DATABASE IF NOT EXISTS OLearningFromAC1;
USE OLearningFromAC1;
CREATE TABLE IF NOT EXISTS Script3student(roll_no INT PRIMARY KEY, name VARCHAR(50) NOT NULL, marks INT NOT NULL, grade VARCHAR(2), city VARCHAR(50) NOT NULL);
INSERT INTO Script3student(roll_no,name,marks,grade,city) VALUES(101,"Anil",78,"C","Pune"),(102,"Bhumika",93,"A","Mumbai"),(103,"Chetan",85,"B","Mumbai"),(104,"Dhruv",82,"B","Delhi"),(105,"Harsh",88,"B","Indore"),(106,"Farah",80,"C","Delhi");

SET SQL_SAFE_UPDATES=0; #This command turns the safe mode off, so that we can modify the existing content in the table. write "1" at the place of "0" to turn it back on 

###Some table related queries;
##UPDATE:
UPDATE Script3student SET grade="O" WHERE grade="A"; #This is how we can update any row in a table
UPDATE Script3student SET marks=92, grade="A" WHERE roll_no=105; #Here we have updated 2 things in a row based on the roll number
UPDATE Script3student SET marks=marks+1; #Here we have added 1 to marks of all the students

##DELETE:
DELETE FROM Script3student WHERE roll_no=106; #This has deleted the row having "106" roll_no.  

##ALTER:
#Add the column:
ALTER TABLE Script3student ADD COLUMN mob_no BIGINT NOT NULL DEFAULT 1111111111;
#Rename table:
CREATE TABLE Script3temp1(id INT);
SHOW TABLES;
ALTER TABLE Script3temp1 RENAME TO Script3demo1; #This will rename table "temp1" to "demo1"
SHOW TABLES;
DROP TABLE Script3demo1;
#Change column(rename):
ALTER TABLE Script3student CHANGE COLUMN mob_no mobile BIGINT NOT NULL; #Here the name of the column "mob_no" is changed to "mobile"
#Modify column(datatype/constraints)
ALTER TABLE Script3student MODIFY mobile VARCHAR(10) NOT NULL; #Here we have changer the datatype from int to varchar(10)
#Drop column:
ALTER TABLE Script3student DROP mobile;

##TRUNCATE:
CREATE TABLE Script3temp1(id INT, name VARCHAR(10));
INSERT INTO Script3temp1 VALUES(101,"MOKSH"),(102,"SUJAL");
SHOW TABLES;
SELECT * FROM Script3temp1;
TRUNCATE TABLE Script3temp1; #delete whole data of the table, while letting the table to exist.
SELECT * FROM Script3temp1;
SHOW TABLES;

SELECT * FROM Script3student;
