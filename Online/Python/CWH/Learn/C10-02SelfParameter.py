'''
class Employee:
    lang="Py"
    salary=1200000
    def getSalary():
        print(f"Salary of Employee is {salary}, and language is {lang}")

obj1=Employee()
obj1.getSalary() 

#this statement is equivatent to "Employee.getSalary(obj1)" but we have not given any parameter in the class's method, when defined, therefore, we have to to give "self" there, which will define 1 argument in the method and whenit will be called so atlest it will have that one required argument, here, obj1. (object_name=self) 
'''

class Employee:
    lang="Py"
    salary=1200000
    def getSalary(self): #here "self" means wo object jispar ye method run ho raha hai
        print(f"Salary of {self.name} is {self.salary}, and language is {self.lang}")
        #here "self.salary" and "self.lang" tells object ki salary and language

    def greet(self): 
        #give "self" is necesary everytime we define the method in a class as it becomes "class.method(object)"
        print(f"Good Morning,{self.name}")

obj1=Employee()
obj1.name="Moksh"
obj1.greet()
obj1.getSalary() 
Employee.getSalary(obj1) #above statement is equivalent to this
'''here "obj1.getSalary()" is equivalent to "Employee.getSalary(obj1)", there we have defined "self" in the 
   method defination. and also have to declare the attributes inside the method defination as "self"'''



'''NOTE: class me yadi ham method banate hai to uske parameter me ek "self" as an argument dena zaruri hai chahe 
ham use use kare ya na kare.'''