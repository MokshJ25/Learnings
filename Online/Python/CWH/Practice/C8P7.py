def rem(l,word):
    n=[]
    for i in l:
        if not(i==word):
            n.append(i.strip(word)) 
    return n

a=["Aadish","Kruti","Moksh","Ginni","sh"]
print(f"List before removing and striping is: {a}")
print("List after removing and striping is: ",end="")
print(rem(a,"sh"))

'''strip() used to remove leading and ending characters from a string It returns a new string 
   with the specified characters removed, leaving the original string unchanged'''