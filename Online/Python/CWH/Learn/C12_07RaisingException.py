a=int(input("Enter first number: "))
b=int(input("Enter second number: "))

if(b==0):
    raise ZeroDivisionError("Cant Divide by 0")
else:
    print(f"Answer is: {a/b}")

#unlike try-except, when we raise the error, it crashes the progrsm