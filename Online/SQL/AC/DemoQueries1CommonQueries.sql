#SOME DATABASE RELASTED AND OTHER QUERIES:

#NOTE: SQL is not a case sensitive language so we can write the queries in small or caps, this wont affect our query. But note that table's name is case sensitive in SQL
CREATE DATABASE OLearningFromAC1; #To create a new database
CREATE DATABASE IF NOT EXISTS OLearningFromAC1; #create a new database, only if that named database do not exist, or it will give warning, not error. its a good practice
CREATE DATABASE Script1Demo1;
DROP DATABASE IF EXISTS Script1Demo1; #deletes a new database, only if that named database exist, it will give warning, not error.

USE OLearningFromAC1; #To use the selected database

SHOW DATABASES; #shows all the available databases
SHOW TABLES; #shows all the tables present in the selected database

#----------------------------------------------------------------------------------------------------------------
#SOME TABLE RELATED QUERIES:

CREATE TABLE IF NOT EXISTS Script1Student(id INT PRIMARY KEY,name VARCHAR(50), age INT NOT NULL); 
#This will create a "student" named table, with "id" column as the primary key having integer datatype, "name" column having varchar datatype and can hold only 50 characters, "age" column cannot be null there must me some value
# we can also define a primary key as: "CREATE TABLE IF NOT EXISTS student(id INT,name VARCHAR(50), age INT, PRIMARY KEY(id));"
#we can also add two or more(combination of) columns in primary key: PRIMARY KEY(id, name); #here, neither "id" will be primary key, nor "name" will be primary key, here, the combination of "name" and "id" will be primary key

INSERT INTO Script1Student VALUE(1,"MOKSH","21");# insert values in the table columnwise
INSERT INTO Script1Student VALUE(2,"GINNI","21");
#or
INSERT INTO Script1Student (id, name, age) VALUES (3,"Aadish", 26),(4,"Kruti", 26); #It is one more way we can enter the values in our table
INSERT INTO Script1Student VALUES(5,"Naman",26);

set sql_safe_updates=0;#this will turn safe update mode off. we can turn it on by replacing "1" with "0"

UPDATE Script1Student SET AGE=25 WHERE name="Aadish"; #This will updaste the age of aadish

DELETE FROM Script1Student WHERE id=5; #This will delete the row where id=5 

SELECT * FROM Script1Student; #"*" means "all" in SQL

CREATE TABLE Script1Demo2(id INT PRIMARY KEY);
DROP TABLE IF EXISTS Script1Demo2; #This will delete the specified table from the database, if table exists.
#----------------------------------------------------------------------------------------------------------------
#SOME KEYS AND CONSTRAINTS

use OLearningFromAC1;
create table if not exists Script1KAndC1(id int unique); #we have given "unique" constraint to "id", therefore it will hold unique values

insert into Script1KAndC1 values(101);
insert into Script1KAndC1 values(101); #we cannot add 101 again because we have given "unique" constraint

CREATE TABLE IF NOT EXISTS Script1KAndC2(id INT PRIMARY KEY, salary int DEFAULT 25000); #we have given "DEFAULT" constraint to "salary", therefore it will hold "25000" by default(if no value is given)
INSERT INTO Script1KAndC2(id) VALUES (101);


SELECT * FROM Script1KAndC1;
SELECT * FROM Script1KAndC2;