class Employee:
    company = "ITC"
    def __init__(self, name, lang, salary):
        self.name = name
        self.lang = lang
        self.salary = salary
    def show(self):
        print(f"The name of the Employee is {self.name} and the salary is {self.salary}")

class Coder:
    def printLang(self):
        print(f"The language of the coder is: {self.lang}")

class Programmer(Employee, Coder):
    company = "ITC Infotech"
    
    def showLang(self):
        print(f"The name is {self.name} and the language is {self.lang}")
        
name = input("Enter the name: ")
language = input("Enter the language: ")
salary = int(input("Enter the salary: "))

a = Programmer(name, language, salary)

a.show()
a.printLang()
a.showLang()
