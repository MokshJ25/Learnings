#WAP to print table in reverse order

a= int(input("Enter the number: "))

for i in range(10,0,-1): #range() do not count backwards, therefore we have to give "-1" in step_size(obvio)
    print(i*a)

'''
or we can use another logic:
m=int(input("Enter the number: "))
for j in range(1,11):
    print(m*(11-j))
'''
