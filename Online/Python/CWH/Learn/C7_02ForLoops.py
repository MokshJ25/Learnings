#1: iterate through a sequence(here, list and string)
print("iterate through a sequence(here, list and string)")
a=[1,2,3,"Moksh",True,"Ginni"]
for i1 in a: #it iterates the list
    print(i1)
print("")
b="Moksh"
for i2 in b: #it iterates the string
    print(i2)
print("")

#2: range() function 
print("range() function: ")
for j in range(7): #if the start is not specified then it will start from 0 by default
    print(j)
print("")
#Syntax for range() function: "range(start,stop,step_size)" here, "stop" is excluded
for k in range(1,11,2):
    print(k)
print("")

#For loop with else
print("For loop with else")
for l in range(5,11):
    print(l)
else: #"else" can be used with the for loop. it will be executed, when for's execution ends(it is optional)
    print("Else in execution...")
