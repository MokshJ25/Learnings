#SHOWING SOME CLAUSES AND FUNCTIONS ON THE DATA

CREATE DATABASE IF NOT EXISTS OLearningFromAC1;
USE OLearningFromAC1;
CREATE TABLE IF NOT EXISTS Script2student(roll_no INT PRIMARY KEY, name VARCHAR(50) NOT NULL, marks INT NOT NULL, grade VARCHAR(2), city VARCHAR(50) NOT NULL);
INSERT INTO Script2student(roll_no,name,marks,grade,city) VALUES(101,"Anil",78,"C","Pune"),(102,"Bhumika",93,"A","Mumbai"),(103,"Chetan",85,"B","Mumbai"),(104,"Dhruv",82,"B","Delhi"),(105,"Harsh",88,"B","Indore"),(106,"Farah",80,"C","Delhi");

#Use of "SELECT":
SELECT roll_no,name FROM Script2student;
SELECT * FROM Script2student;

#Use of "DISTINCT" keyword:
SELECT DISTINCT city FROM Script2student; #UsE OF "DISTINCT" Keyword
 
#Use of "WHERE":
SELECT * FROM Script2student WHERE marks>80;
SELECT * FROM Script2student WHERE marks+10>95; #shows the use of "+" arithematic operator
SELECT * FROM Script2student WHERE city="MUMBAI";
SELECT * FROM Script2student WHERE city="MUMBAI" AND marks>90; #shows the use of "and" logical operator
SELECT * FROM Script2student WHERE marks BETWEEN 80 AND 90; #shows the use of "BETWEEN" operator 
SELECT * FROM Script2student WHERE city IN ("indore","mumbai");
SELECT * FROM Script2student WHERE city NOT IN ("indore","mumbai");

#Use of "LIMIT" clause:
SELECT * FROM Script2student WHERE marks>70 LIMIT 3;  

#Use of "ORDER BY" clause:
SELECT * FROM Script2student ORDER BY marks ASC;  
SELECT * FROM Script2student ORDER BY marks DESC LIMIT 3; #this will print the top 3 students markswise 

#Use of "GROUP BY" clause:
SELECT city,name,COUNT(roll_no) FROM Script2student GROUP BY city,name;
SELECT city,AVG(roll_no) FROM Script2student GROUP BY city; #This will help[ us finding the average of marks in each city
SELECT grade,COUNT(roll_no) FROM Script2student GROUP BY grade ORDER BY(grade) ASC; #This will give count of each grades of students

#Use of "HAVING" clause:
SELECT city,COUNT(roll_no) FROM Script2student GROUP BY city HAVING MAX(marks)>90; #Count the no. of students in each city where the max. marks crosses 90
SELECT city,COUNT(roll_no) FROM Script2student WHERE grade="A" GROUP BY city HAVING MAX(marks)>90; #Using "WHERE" and "HAVING" together

##DEMO FOR AGGREGATE FUNCTION:
#MAX():
SELECT MAX(marks) FROM Script2student;
#MIN():
SELECT MIN(marks) FROM Script2student;
#AVG():
SELECT AVG(marks) FROM Script2student;
#COUNT():
SELECT COUNT(marks) FROM Script2student; 
#SUM():
SELECT SUM(marks) FROM Script2student;
