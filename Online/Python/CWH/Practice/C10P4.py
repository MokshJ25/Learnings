#Create class calculator capable of finding square, cube, and roots

class Calc:
    def __init__(self,n):
        self.n=n
    
    @staticmethod
    def greet():
        print(f"Greetings!!!!")

    def calculate(self):
        print(f"Square of {self.n} is: {self.n**2}")
        print(f"Cube of {self.n} is: {self.n**3}")
        print(f"Square root of {self.n} is: {self.n**0.5}")
    
a=int(input("Enter the number: "))
obj1=Calc(a)
obj1.greet()
obj1.calculate()
