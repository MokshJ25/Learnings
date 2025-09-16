#WAP to print * pattern 1

n=int(input("Enter the number: "))

for i in range(1,n+1):
    print(" "*(n-i), end="") #(end="") does not send the next statement to the next line
    print("*"*(2*i-1)) #(2*n-1) is the formula for odd numbers
