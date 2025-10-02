#Create a class(2-DVector) and use it to create another class representing a 3-D vector

class TwoDVector:
    def __init__(self,i,j):
        self.i=i 
        self.j=j 
    def show(self):
        print(f"The Vector is {self.i}i {self.j}j")

class ThreeDVector(TwoDVector):
    def __init__(self,i,j,k): 
        super().__init__(i,j) #this "super()" will use the consturctor of the parent as its class again 
        self.k=k 
    def show(self):
        print(f"The Vector is {self.i}i {self.j}j {self.k}k")


a=TwoDVector(1,2)
a.show()
b=ThreeDVector(4,5,6)
b.show()