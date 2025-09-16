#WAP to find whether the given post is talking about "Moksh" or not

a=input("Enter the post here: ")
if("Moksh".lower() in a.lower()): #different capital combinations se "Moksh" likha jo usko resolve karne ke lie
    print("Yes! this post is talking about Moksh")
else:
    print("No! this post is not talking about Moksh")
