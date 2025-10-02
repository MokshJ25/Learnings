#if we dont want to pass the object inside the method defination(means we dont want to pass "self" inside the argument in the method defination), we can mark that method as static

class Employee:
    @staticmethod
    def greet(): #here we dont need pass any object in it as we marked it as static
        print("Hello")

obj1=Employee()
obj1.greet()
