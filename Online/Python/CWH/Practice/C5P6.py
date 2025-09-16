#Create empty dictionaryn and take the values from users

dict={}

a=input("F1 Enter the subject:")
b=input("F2 Enter the subject:")
c=input("F3 Enter the subject:")
d=input("F4 Enter the subject:")

dict.update({"Aadish":a})
dict.update({"Moksh":b})
dict.update({"Kruti":c})
dict.update({"Ginni":d})

print(dict)