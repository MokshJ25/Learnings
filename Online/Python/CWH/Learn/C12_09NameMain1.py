def myFunc():
    print("Hello World!")

myFunc()
print(__name__) #Here this will give "__main__" because we are runnig it in same file where it is present

if (__name__=="__main__"): #ye use karke we can make sure ki ye block of code tab hi chale jab code directly file se run ho
    print("We are directly running this code")