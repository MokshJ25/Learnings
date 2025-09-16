#WAP to find sum of first n natural numbers

a=int(input("Enter n(last number): "))

i,j=1,0
while(i<=a):
    j+=i
    i+=1
print(f"Sum of natural numbers till {a} is: {j}")
