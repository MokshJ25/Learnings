#Format the template given in the question

a=input("Enter your name: ")
b=input("Enter the date: ")
letter=f'''Dear {a},\nYou are selected!\n{b}''' #we have markedn it as a "f-string"
print(letter)