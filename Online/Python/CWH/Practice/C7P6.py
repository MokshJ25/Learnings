#WAP to find factorial using for loop

a=int(input("Enter the number: "))
j=1
for i in range(1,a+1):
    j=j*i
print(f"Factorial of {a} is: {j}")
