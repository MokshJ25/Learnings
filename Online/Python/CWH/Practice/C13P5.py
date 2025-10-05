# WAP to find the maximum of the numbers in a list using the reduce function

from functools import reduce

l=[1,2,5,21,20,45,37,80,43,40]

def greater(a,b):
    if(a>b):
        return a
    return b

print("Greates number in the list is:",reduce(greater,l))