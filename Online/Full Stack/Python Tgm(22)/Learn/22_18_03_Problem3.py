#Program to reverse a string without using slicing operator:

s=input("Enter the string: ")
rev=""

for i in s:
    rev=i+rev #here we have to write "i+rev" in this order only. "rev+i" will not reverse the string 
    print(rev)

print(f"Original: {s}")
print(f"Reversed: {rev}")

#or
# last=len(s)
# for i in range(last,0,-1):
#     print(s[i-1]) #since, index starts from 0