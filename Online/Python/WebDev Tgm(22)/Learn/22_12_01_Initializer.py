# class Abc:
#     name
#     def display_name(self):
#         self.name="Moksh"
#         print("My name is:",name)

# obj=Abc()
# obj.display_name()
#The above code will give an error because we are trying to access the variable "name" inside the method "display_name" without declaring __init__ method. So, we can declare the variable "name" inside the __init__ method and then we can access it inside the method "display_name".


class Abc:
    def __init__(self,name):
        self.name=name
    def display_name(self):
        print("Welcome",self.name)

nm=input("Enter your name: ")
obj=Abc(nm)
obj.display_name()