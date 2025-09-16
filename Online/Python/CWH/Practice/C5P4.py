#what will be the length of the set?

s=set()
s.add(20)
s.add(20.0) #in python, 20(int) and 20.0(float) are equal, therefore they will be considered duplicate in set 
s.add("20")
print(s)
print(len(s))