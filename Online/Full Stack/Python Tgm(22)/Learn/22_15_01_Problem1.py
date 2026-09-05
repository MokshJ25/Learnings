#Count the character in a string

str=input("Enter the string: ").lower() #will accept the string and convert it into lowercase
a=input("Enter the character to be searched: ").lower()
temp=0

for i in str:
    if(i==a):
        temp=temp+1

print(f"Character {a} is occuring {temp} times in {str}")