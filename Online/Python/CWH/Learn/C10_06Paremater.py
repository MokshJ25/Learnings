class Employee:
    lang="Py"
    salary=1200000
    def __init__(self, name, salary, language):
        print("init is called")
        self.name=name
        self.salary=salary
        self.lang=language

    def greet(self): 
        print(f"Good Morning,{self.name}")
    
    def getSalary(self):
        print(f"Salary of {self.name} is {self.salary}, and language is {self.lang}")

obj1=Employee("Moksh",2000000,"Java")
# obj1.name="Moksh"
obj1.greet()
obj1.getSalary()
print("\n"+obj1.name,obj1.salary,obj1.lang)