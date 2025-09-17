#WAP to find sum of first n natural numbers using recurssion

def sumOfNum(n):
    if(n==1):
        return 1
    else:
        return n+sumOfNum(n-1)
    
a=int(input("Enter the limit number: "))
print(f"Sum of first {a} natural numbers is: {sumOfNum(a)}")
