'''
class Number:
    def __init__(self,n):
        self.n=n

n=Number(10)
m=Number(20)

print(n+m) #here , n and m are the objects of the class, therefore we need to specify what that "+" operator mean
#here, this code will give error as "n" and "m" are the instances of the class and we need to specify the operator for the objects
'''

class Number:
    def __init__(self,n):
        self.n=n
    def __add__(self,num):
        return self.n + num.n

n=Number(10)
m=Number(20)

print(n+m)
