#Type Hints: tgese give the user hints while typing thgat which method will return what and which variable is of which type

age: int = 21

def greet(name:str)->str:
    return f"Hello {name}!"
print(greet("Moksh"))
print(age)