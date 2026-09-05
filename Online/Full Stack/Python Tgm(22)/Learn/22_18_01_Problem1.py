#check weather a character is present in a string or not. if yes, print its index

s= input("Enter the string: ")
c= input("Enter the character: ")[0] #if user enters string by mistake, then character at index 0 will be considered
temp=0

for i in range(len(s)):
    if(c==s[i]):
        print(f"character {c} is at the {i} index")
        temp=1
if temp==0:
    print(f"character {c} is not in string {s}")

#or ----------------------------------------
# print(len(s))
# pos=s.index(c)
# print(f"character {c} is at the {pos} index")

#or ----------------------------------------
#temp=0
# for i in s:
#     if(c==i):
#         print(f"character {c} is at the {temp} index")
#     temp=temp+1
