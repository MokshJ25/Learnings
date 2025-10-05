#WAP to print third, fifth, and seventh element from a list using enumerate funcion

l=[1,24,53,45,63,98,49,32,899,21,65,289]

for n,item in enumerate(l):
    if(n==2 or n==4 or n==6):
        print(item)