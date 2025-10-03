def fact(n):
    if (n==0 or n==1):
        return 1
    else:
        return n*fact(n-1)

a=int(input("Enter the number: "))
b=fact(a)
print(f"Factorial for {a} is: {b}")