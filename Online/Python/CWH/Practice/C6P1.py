#WAP to find the greatest of four numbers:

a= int(input("Enter number1: "))
b= int(input("Enter number2: "))
c= int(input("Enter number3: "))
d= int(input("Enter number4: "))

if(a>b and a>c and a>d):
    print(f"{a} is greater")
elif(b>a and b>c and b>d):
    print(f"{b} is greater")
elif(c>b and c>a and c>d):
    print(f"{c} is greater")
elif(d>b and d>c and d>a):
    print(f"{d} is greater")
elif(a==b==c==d):
    print("All are equal")
else:                               
    print("Invalid")
