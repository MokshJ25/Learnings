#SHOWING SOME SUNQUERY/INNER QUERY/NESTED QUERY AND VIEW RELATED QUERIES:

CREATE DATABASE IF NOT EXISTS OLearningFromAC1;
USE OLearningFromAC1;
CREATE TABLE IF NOT EXISTS Script6student(roll_no INT PRIMARY KEY, name VARCHAR(50) NOT NULL, marks INT NOT NULL, city VARCHAR(50));
INSERT INTO Script6student(roll_no,name,marks,city) VALUES(101,"Anil",78,"Pune"),(102,"Bhumika",93,"Mumbai"),(103,"Chetan",85,"Mumbai"),(104,"Dhruv",82,"Delhi"),(105,"Harsh",88,"Delhi"),(106,"Farah",80,"Delhi");

SELECT * FROM Script6student;

###USING UNDER WHERE:
##Find the details of the students who scored more than the average score of the class:
#Static way or general way:
SELECT AVG(marks) FROM Script6student; #Finding the average score of the class
SELECT name,marks FROM Script6student WHERE marks>84.3333; #Finding the list of name and marks of the students with marks more than the average marks of whole class, i.e., 84.3333
#the above method is static, i.e., if any student god added, so the average will change, so each time we have to change the average manually. it is not effecient. Therefore here we will now use the subqueries.
#Dynamic way, using subqueries:
SELECT name,marks FROM Script6student WHERE marks>(SELECT AVG(marks) FROM Script6student); #here, we have written subqueryinner query/ nested query, betweeen "()". this is the dynamic method, here if the average will change so we need not to change the average manually.

##Find the details of the students with even roll number:
SELECT name, roll_no, marks FROM Script6student WHERE roll_no%2=0;
#or
SELECT name,roll_no,marks FROM Script6student where roll_no IN(SELECT roll_no FROM Script6student WHERE roll_no%2=0); #it is done using the subquery
#above both the queries follows dynamic approach


###USING UNDER FROM:
##Find the max marks from the students of delhi:
SELECT MAX(marks) FROM Script6student WHERE city="Delhi";#doesnt uses subquery

SELECT MAX(marks) FROM (SELECT * FROM Script6student WHERE city="Delhi") as temp; #uses subquery
#above both methods gives us the max marks from delhi but second method uses subquering.


###USING UNDER SELECT:
##Find the maximum marks from the student table
SELECT MAX(marks) FROM Script6student; #here we hasve not used subquery

SELECT (SELECT MAX(MARKS) FROM Script6student); #here we have used the subquery


####VIWE
CREATE VIEW Script6teacher_view AS SELECT roll_no,name,marks FROM Script6student; #here we have created a view from the main table. we can do all the operatrion on this table also what we can do on main table.
SELECT * FROM Script6teacher_view WHERE marks>85; #we can perform all the other operations and quering also
DROP VIEW Script6teacher_view; #This is how we can delete a view 

drop database democollege6;