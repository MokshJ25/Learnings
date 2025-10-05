#A list contains the multiplication table of 7. WAP to convert it to vertical string of same numbers.

l=[str(7*i) for i in range(1,11)]

s="\n".join(l)
print(s)