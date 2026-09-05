#use 1:If you try to modify a variable without declaring it global, Python creates a separate local copy. The original global variable remains unchanged.
count = 10  # Global variable

def increment():
    count = 20  # This creates a NEW local variable named count
    print("Inside function:", count)

increment()
print("Outside function:", count)


#use 2: Adding global tells Python to link the local name directly to the module-level variable.
count = 10  # Global variable

def increment():
    global count  # Link to the global variable
    count = 20    # Modifies the global variable
    print("Inside function:", count)

increment()
print("Outside function:", count)


#use 3:You can also use the global keyword to create a brand new global variable from inside a function, even if it didn't exist before outside.
def create_variable():
    global new_var
    new_var = "I was born inside a function!"

create_variable()
print(new_var)  # Accessible because it was declared global


