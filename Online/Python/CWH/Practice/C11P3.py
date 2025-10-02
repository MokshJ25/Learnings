#Create a class "Employee" and add salary and increment properties to it. Write a method "salaryAfterIncrement" with a @property decorator woth a setter which change the value od increment based on the salary

class Employee:
    salary=234
    inc=20
    
    @property
    def salaryAfterIncrement(self):
        return (self.salary+self.salary*(self.inc/100))
    @salaryAfterIncrement.setter
    def salaryAfterIncrement(self,salary):
        self.inc=((salary/self.salary)-1)*100 #its a mathematical formula


e=Employee()
# print(e.salaryAfterIncrement)
e.salaryAfterIncrement=280
print(e.inc)