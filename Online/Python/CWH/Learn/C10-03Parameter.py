class Employee:
    lang="Py"
    salary=1200000
    def getSalary(self,a,b):
        print(f"Salary of {self.name} is {self.salary}, and language is {self.lang}")
        print(f"checking for other parameters: sum is: {a+b}")

    def greet(self):
        print(f"Good Morning,{self.name}")

obj1=Employee()
obj1.name="Moksh"
a1=b1=1
obj1.getSalary(a1,b1) 
obj1.greet()
