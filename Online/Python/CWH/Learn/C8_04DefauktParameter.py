def avg(e,f="Problem Solved!"):
    a=int(input("Enter the number: "))
    b=int(input("Enter the number: "))
    c=int(input("Enter the number: "))
    print(e,(a+b+c)/3,f)

d="Average is:"   
g="Did you Understand?" 
avg(d) #here, we have not given any argument for "f" part, therfore it will use the default parameter
avg(d,g) #here, we have used a parameter at the place of "f", so the default parameter will not be used 