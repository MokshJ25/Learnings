a=(1,7,2,521,5.5,10)
print("length of a is:",len(a))

#some functions
print("a.count(1) will give:", a.count(1)) #it will return the number of times "1" occurs in the tuple
print("a.index(1) will give:", a.index(7)) #it will return the index of "1"

#use of "in"
print("'2 \"in\" a' will give:", 2 in a) #it will check the availability
print("'3 \"in\" a' will give:", 3 in a) #it will check the availability

#min() and max() in the tuple
print("min(a) will return", min(a)) #it will find the minimum term in the tuple
print("max(a) will return", max(a)) #it will find the maximum term in the tuple

#Slicing
print(a[1:4])

#Unpacking
one, two, three, four, five, six=a #its necessary to assign no. of variables equal to no. of elements (obvio)
print(f"one:{one}, two:{two}, three:{three}")

#etc....