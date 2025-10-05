l=[1,15,8,2,4,2,7,8,3,25,5]

#without list comprehension we have to do:
sqdlist1=[]
for item in l:
    sqdlist1.append(item*item)
print ("before list comprehension:\n",sqdlist1)

#but after list comprehension, we need to do:
sqdlist2=[i*i for i in l] #we need to write only this one line isntead of above many lines
print ("after list comprehension:\n",sqdlist2)