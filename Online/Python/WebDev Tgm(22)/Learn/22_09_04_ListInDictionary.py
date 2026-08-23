dl={"L1":[1,2,3],"L2":[4,5,6],"L3":[7,8,9],"L4":[10,11,12],"L5":[13,14,15]}
DEven=[]
print(dl)

for i in dl:
    # print("i is: ",i)
    for j in dl[i]:  
        # print("j is: ",j)
        if j%2==0:
            DEven.append(j)

print("Even numbers in the dictionary are: ",DEven)