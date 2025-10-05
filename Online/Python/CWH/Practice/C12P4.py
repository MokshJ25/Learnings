#WAP to dusplay a/b where a and b are integers. if b=0, display infinit by handling ZeroDivisionError

try:
    a=int(input("Enter the numerator: "))
    b=int(input("Enter the denominator: "))
    print(a/b)
except ZeroDivisionError:
    print("Infinite")

    