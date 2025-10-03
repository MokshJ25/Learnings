for i in range(11):
    print(i)
    if(i==7):
        break #it will break(exit) the loop once i will become 7
    elif(i==5):
        continue #it will skip the iteration when i will become 5 
else: #this will not be executed as it connected to for loop, and it got exited, then else will also be exited
    print("We are out of the loop")
