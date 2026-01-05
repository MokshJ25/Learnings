#SHOWING SOME JOINS AND UNION RELATED QUERIES:

CREATE DATABASE IF NOT EXISTS OLearningFromAC1;
USE OLearningFromAC1;

CREATE TABLE IF NOT EXISTS Script5student(student_id INT PRIMARY KEY, name VARCHAR(50));
CREATE TABLE IF NOT EXISTS Script5course(student_id INT PRIMARY KEY, course VARCHAR(50));

INSERT INTO Script5student(student_id,name) VALUES(101,"Adam"),(102,"Bob"),(103,"Ceasy");
INSERT INTO Script5course(student_id,course) VALUES(102,"English"),(105,"Math"),(103,"Science"),(107,"Computer Science");

SELECT * FROM Script5student;
SELECT * FROM Script5course;

#INNER JOIN:
SELECT * FROM Script5student AS s INNER JOIN Script5course AS c ON s.student_id=c.student_id; #here we have inner joined two tables, i.e., student and course, on the basis that in the student_id named cclumn in student and student_id named column in course, if having equal value, will be showed. Here we have also used the concept of ALIAS, i.e., we have altered the name, using "AS", just for quering.

#LEFT JOIN:
SELECT * FROM Script5student LEFT JOIN Script5course ON Script5student.student_id=Script5course.student_id;

#RIGHT JOIN:
SELECT * FROM Script5student RIGHT JOIN Script5course ON Script5student.student_id=Script5course.student_id; 

#FULL JOIN:(In MySQL, there is no concept of full join. to make it work, we make union of left and right join)
SELECT * FROM Script5student AS s LEFT JOIN Script5course AS c ON s.student_id=c.student_id UNION SELECT * FROM Script5student AS s RIGHT JOIN Script5course AS c ON s.student_id=c.student_id; #This can show the NULL at the place of missing values in both the tables  

#LEFT EXCLUSIVE JOIN:(Do not contain central overlapping part or right part)
SELECT * FROM Script5student AS s LEFT JOIN Script5course AS c ON s.student_id=c.student_id WHERE c.student_id IS NULL;

#RIGHT EXCLUSIVE JOIN:(Do not contain central overlapping part or left part)
SELECT * FROM Script5student AS s RIGHT JOIN Script5course AS c ON s.student_id=c.student_id WHERE s.student_id IS NULL;

#SELF JOIN:
CREATE TABLE IF NOT EXISTS Script5selfJoinDemo(id INT PRIMARY KEY, name VARCHAR(50), manager_id INT);
INSERT INTO Script5selfJoinDemo(id,name,manager_id) VALUES(101,"Adam",103),(102,"Bob",104),(103,"Ceasy", NULL),(104,"Donald",103);
SELECT * FROM Script5selfJoinDemo;

SELECT sjd1.name AS manager_name, sjd2.name FROM Script5selfJoinDemo as sjd1 JOIN Script5selfJoinDemo as sjd2 on sjd1.id=sjd2.manager_id; #Here we have frinted the manager names of the employees, contained in a single table. "sjd1.name AS manager_name" shows that table 1 me jo "name" column hai uska naam "manager_name" column jaise dikhao

#UNION AND UNION ALL:
SELECT name FROM Script5student UNION SELECT name FROM Script5student; #This gives combined data of both the tables but not show duplicate values
SELECT name FROM Script5student UNION ALL SELECT name FROM Script5student; #This gives combined data of both the tables and shows duplicate values