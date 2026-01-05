#SHOWING SOME FOREIGN KEY RELATED QUERIES

CREATE DATABASE IF NOT EXISTS OLearningFromAC1;

USE OLearningFromAC1;

CREATE TABLE IF NOT EXISTS Script4dept(id INT PRIMARY KEY, name VARCHAR(50) NOT NULL);
CREATE TABLE IF NOT EXISTS Script4teachers(id INT PRIMARY KEY, name VARCHAR(50) NOT NULL, dept_id INT, city VARCHAR(50) NOT NULL, FOREIGN KEY(dept_id) REFERENCES Script4dept(id) ON DELETE CASCADE ON UPDATE CASCADE); #"ON DELETE CASCADE" and "ON UPDATE CASCADE" make sure that the values in foreign key in child table must also update and delete with the updation and deletion in the pimary key of parent primary key, respectively.

INSERT INTO Script4dept(id,name) VALUES(101,"English"),(102,"Hindi"),(103,"Maths"),(104,"Science");
INSERT INTO Script4teachers(id,name,dept_id,city) VALUES(01,"Rekha",101,"Shrinagar"),(102,"Kanhaiya",102,"Choti Khargone"),(03,"Abhijeet",103,"Shrinagar"),(04,"Kirti",104,"Mandleshwar"),(05,"Varsha",104,"Maheshwar"),(06,"Soni",102,"Karhi");

UPDATE Script4dept SET id=105 WHERE id=103; #Here we have updated one item in the promary key of the parent table, and since we have used "ON UPDATE CASCADE" for our foreign key therefore it will also be reflected in our child table's foreign key, i.e. teachers table's dept_id column, without doing any update in that teachers table

SELECT * FROM Script4dept;
SELECT * FROM Script4teachers;

DROP TABLE Script4teachers;