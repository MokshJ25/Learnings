#WAP that generates a random number and asks the user to guess it. If the player guess is higher than the actual number, the program displays "Lower number please". Similarly with lower numbers. And when guess the correct number, it should show the correct number of guesses user took to guess the correct number

import random

n=random.randint(1,100)
a=-1
guess=0
while (a!=n):
    a=int(input("Guess the number between 1 to 100: "))
    guess+=1
    if(a==n):
        print(f"Guessed number is correct, and you have taken {guess} chances")
    elif(a<n):
        print("Guess higher")
    elif(a>n):
        print("Guess lower")

