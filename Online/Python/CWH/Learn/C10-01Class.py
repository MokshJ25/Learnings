class Employee: #its a class named "Employee"
    language="Py"
    salary=1200000

obj1=Employee() #its an object of "Employee" class, named "obj"
obj1.name="Moksh"
print(obj1.name, obj1.language, obj1.salary)

obj2=Employee() #its an object of "Employee" class, named "obj"
obj2.name="Aadi"
obj2.language="Java" #it shows that instance attribute is on more priority than a class attribute
print(obj2.name, obj2.language, obj2.salary)

'''In the above code, "language", "salary", are class attributes as they directly belongs to the class. 
   while, "name" is the object/instance attribute as it belongs to that object only'''