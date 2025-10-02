#Create class for storing information of few programmers

class Programmer:
    company="Microsoft"
    def __init__(self, name, lang, salary):
        self.name = name
        self.lang = lang
        self.salary = salary

    def empInfo(self):
        print(self.company, self.name, self.lang, self.salary)

obj1 = Programmer("Moksh", "Java", 10000000)
obj1.empInfo()
obj2 = Programmer("Ginni", "Python", 10000000)
obj2.empInfo()
