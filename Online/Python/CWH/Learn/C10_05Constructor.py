class Employee:
    lang="Py"
    salary=1200000
    def __init__(self): #dunder method(started by "__"). it will be automatically be called as the object is created
        print("init is called")

    def getSalary(self):
        print(f"Salary of {self.name} is {self.salary}, and language is {self.lang}")

    def greet(self): 
        print(f"Good Morning,{self.name}")

obj1=Employee() #here an object is created, so the init method will be called
obj1.name="Moksh"
obj1.greet()
obj1.getSalary() 
obj2=Employee() #here an object is created, so the init method will be called again

#everytime we will create the object the init method will be called
#constructor's job is to initialize attributes (variables) for that object.