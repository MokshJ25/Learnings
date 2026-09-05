#Dictionary:
d={"Name":"John","Age":30,"City":"New York"}
print(d)
d.update({"Age":31})
print(d.get("Age"))
print(d)

for i in d:
    print(i) #It will print only key of dictionary
    print(d[i]) #It will print only the value of the dictionary
    print(i,":",d[i]) #It will print both key and value of the dictionary

