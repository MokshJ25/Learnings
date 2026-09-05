g=[]
n=int(input("Enter the number of guest: "))

for i in range(n):
    g.insert(i,int(input("Enter the age of guest: ")))

c=[]
a=[]
o=[]
iv=0
for j in g:
    if j>0 and j<120:
        if j<18:
            c.append(j)
        elif j>=18 and j<=60: 
            a.append(j)
        elif j>60:
            o.append(j) 
    else:
        iv+=1
        

print("Children:",len(c))
print("Adult:",len(a))
print("Old:",len(o))
print("Invalid entries: ",iv," out of ",n)