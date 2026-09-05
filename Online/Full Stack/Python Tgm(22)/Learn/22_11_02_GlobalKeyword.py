class Abc:
    global name #since this variable is declared as "global", so we can give its value outside the class through its object and we can access it inside the class. If we have not declared it as "global" then we can give its value inside the class only and we cannot alter it outside the class through its object.
obj=Abc()
obj.name="Moksh"
print(obj.name)

#another class:
class Adder:
    global n1,n2
    def add(self,n1,n2):
        return n1+n2

obj2=Adder()
a=obj2.n1=int(input("Enter first number: "))
b=obj2.n2=int(input("Enter second number: "))
print(obj2.add(a,b))