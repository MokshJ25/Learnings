#write a function using lambda expression to find a number is even or odd:

num=int(input("Enter the number: ")) 
even_or_odd= lambda x: "Even" if(x%2==0) else "Odd"
print(even_or_odd(num))