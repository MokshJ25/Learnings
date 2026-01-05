#Write the query to find the average marks in each city in ascending order (refer DemoCollege2)

USE OLearningFromAC1;
SELECT city,AVG(marks) FROM Script2student GROUP BY city ORDER BY AVG(marks) ASC;