class First:
    def fn(self):
        self.fname=input("Enter your first name: ")

class Second(First):
    def ln(self):
        self.lname=input("Enter the last name: ")
    def display(self):
        # self.fn() #we can call the function of parent class in child class also
        # self.ln() #we can call the function of the same class in other function of same class
        #if we call above two functions, then there is no need to call this functions after creating the object of child class. we can directly call the methon of the child class in which we have called abouve functions, i.e., here, "display()"
        print("Full name: ",self.fname, self.lname)

obj=Second()
obj.fn()
obj.ln()
obj.display()