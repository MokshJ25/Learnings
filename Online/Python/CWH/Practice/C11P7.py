#Override the __len__() method in the vector of problem 5 to display the dimensions of the vector

class Vector:
    def __init__(self,l):
        self.l=l
    def __len__(self):
        return len(self.l)

v1=Vector([1,2,3]) #we have made it a list because we can easily use "len()" function on a list
print(len(v1))