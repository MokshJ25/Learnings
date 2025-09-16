#WAP to check fr the number is prime or not

a=int(input("Enter the number: "))

if(a==1 or a==0):
    print(f"{a} is not prime")
else:
    for i in range(2,int(a**0.5)+1):
        if (a%i==0):
            print(f"{a} is not prime")
            break
    else:
        print(f"{a} is prime")
