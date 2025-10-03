class Employee:
    a=1
class Programmer(Employee):
    b=2
class Manager(Programmer):
    c=3

obj1=Employee()
print(obj1.a,"\n") 
#it does not contain b and c

obj2=Programmer()
print(obj2.a)
print(obj2.b,"\n") 
#It does mpt contain c

obj3=Manager()
print(obj3.a)
print(obj3.b)
print(obj3.c)