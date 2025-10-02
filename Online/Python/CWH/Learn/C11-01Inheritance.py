class Employee:
    company="ITC"
    def show(self):
        print(f"The name of the Employee is {self.name} and the salary is {self.salary}")

class Programmer(Employee):
    company="ITC Infotech"
    def showLang(self):
        print(f"The name is {self.name} and the language is {self.lang}")
        
a=Employee()        
b=Programmer()
print(a.company,b.company)
