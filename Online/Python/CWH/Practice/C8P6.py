#WA function to convert inches in cm

def i_to_c(n):
    return n*2.54

a=int(input("Enter inches: "))
print(f"{a} in cm is: {i_to_c(a)}")
