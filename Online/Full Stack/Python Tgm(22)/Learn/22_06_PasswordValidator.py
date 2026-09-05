p=input("Enther the Password: ")
l= len(p)
dg=0
uc=0
lc=0

for i in p:
    if i.isdigit():
        dg=1
    elif i.isupper():
        uc=1
    elif i.islower():
        lc=1

if l>=8 and dg==1 and uc==1 and lc==1:
    print("Password is valid")
else:
    if l<8:
        print("Password must be at least 8 characters long")
    elif p.isspace():
        print("Password cannot be empty or whitespace")
    elif dg==0:
        print("Password must contain at least one digit")
    elif uc==0 and lc==1:
        print("Password must contain at least one uppercase letter")
    elif lc==0 and uc==1: 
        print("Password must contain at least one lowercase letter")
    elif (uc==0 and lc==0):
        print("Password must contain at least one uppercase and one lowercase letter")





# p=input("Enter the Password: ")
# if(len(p)<8):
#     print("Password must be at least 8 characters long")
# else:
#     if not any(char.isdigit() for char in p):
#         print("Password must contain at least one digit")
#     elif not any(char.isupper() for char in p):
#         print("Password must contain at least one uppercase letter")
#     elif not any(char.islower() for char in p):
#         print("Password must contain at least one lowercase letter")
#     elif not any(char in "!@#$%^&*()-_=+[]{}|;:'\",.<>?/`~" for char in p):
#         print("Password must contain at least one special character")
#     else:
#         print("Password is valid")
        