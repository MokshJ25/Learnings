# Map
l=[1,2,3,4,5]
square=lambda x:x*x
sqList=map(square,l)
print(list(sqList))

# Filter
def even(n):
    if(n%2==0):
        return True
    return False
evenList=filter(even,l)
print(list(evenList))

# Reduce
from functools import reduce #we need to import "reduce" from "functools" module

sum=lambda a,b:a+b #it decides hamara list 2-2 karke reduce hoga
mul= lambda a,b:a*b #it decides hamara list 2-2 karke reduce hoga
ans1=reduce(sum,l)
ans2=reduce(mul,l)
print(ans1) #it will give 15 (1+2=3 +3=6 +4=10 +5=15)
print(ans2) #it will give 120 (1*2=2 *3=6 *4=24 *5=120)