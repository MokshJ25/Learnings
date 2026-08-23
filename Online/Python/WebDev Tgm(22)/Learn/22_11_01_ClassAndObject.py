class First:
    a="IAmVariableOfClassFirst"
    def test():
        print("IAmMethodOfClassFirst")

print(First.a)
First.test()#to access the method of class we can use class name directly without giving "self" parameter and without creating object of class 
obj=First()
First.test()#to access the method this way, we need to give "self" parameter in the method definition of class and also we need to create object of class
#test() #we cannot access the method of class directly without using the class. it adds a security factor in out code