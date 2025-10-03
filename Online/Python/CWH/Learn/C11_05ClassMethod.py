class A:
    a1=10
    def show(self): #this method is normal method which belong to the object
        print(f"The value of a1 is(in 'self'): {self.a1}")
obj1=A()
obj1.a1=45
obj1.show()

class B:
    a2=10
    @classmethod #this specifies that we have created this method as the class's method which belong to the class
    def show(cls): #we can use any name other than "cls" also se can use "self" also
        print(f"The value of a2 is(in 'cls'): {cls.a2}")
        
obj1=B()
obj1.a2=45
obj1.show()