'''
f=open("C9-06Demo.txt")
print(f.read)
f.close() #we have to do this explicitly. but we have another way:
'''

with open("C9-06Demo.txt") as f:
    print(f.read())
#now we dont need to explicitly close the file