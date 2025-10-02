class Employee:
    def __init__(self, name):
        print("Employee.__init__() is invoked")
        self.name=name

class Programmer(Employee):
    def __init__(self,name, salary):
        print("Programmer.__init__() is invoked")
        self.salary=salary
        super().__init__(name) #super() enables us to invoke init() on parent class also despite child having init()
    
    def info(self): 
        print(f"{self.name}'s Salary is: {self.salary}")

obj=Programmer("Moksh", 12000000)
obj.info()
        