# In the Student table, change the name of column "name" to "full_name". Delete all the students who scored marks less than 80. Delete the column for grade.

USE OLearningFromAC1;

CREATE TABLE IF NOT EXISTS Que3student(id INT PRIMARY KEY, name VARCHAR(50) NOT NULL,marks INT, grade VARCHAR(2));
SHOW TABLES;
INSERT INTO Que3student(id,name, marks,grade) VALUES(01,"Adam",82,"B"),(02,"Bob",75,"C"),(03,"Ceasy",91,"A"),(04,"Danie",79,"C"),(05,"Elen",87,"B");
SELECT * FROM Que3student;

ALTER TABLE Que3student CHANGE COLUMN name Full_name VARCHAR(50) NOT NULL;
SELECT * FROM Que3student;

DELETE FROM Que3student WHERE marks<80;
SELECT * FROM Que3student;

ALTER TABLE Que3student DROP grade;
SELECT * FROM Que3student;