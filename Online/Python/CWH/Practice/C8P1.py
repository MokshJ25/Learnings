#WAp to find the greatest between three using functions

def gre(a,b,c):
    if(a>b and a>c):
        return a
    elif(a<b and b>c):
        return b
    elif(c>b and a<c):
        return c
    elif(a==b==c):
        return "All are equal"
    else:
        return "Invalid"    
    
one=int(input("Enter the number: "))
two=int(input("Enter the number: "))
three=int(input("Enter the number: "))
ans=gre(one,two,three)
print(f"Greatest among{one},{two},{three} is: {ans}")
