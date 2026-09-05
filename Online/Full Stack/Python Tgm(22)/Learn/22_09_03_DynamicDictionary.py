#Creating a dynamic dictionary:
dc={}
n=int(input("How many elements? "))

for i in range(n):
    key=input("Enter the key: ")
    value=input("Enter the value:")
    dc.update({key:value})
    print("\n")

print("Dictionary created is:\n",dc)