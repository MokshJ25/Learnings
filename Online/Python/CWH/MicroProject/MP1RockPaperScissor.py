#Create a game with the concept of random number

'''
We will choose:
-1: for rock
0:for paper
1: for scissor
'''

import random

dict = {"r": -1, "p": 0, "s": 1}
revDict = {-1: "rock", 0: "paper", 1: "scissor"}

print("Enter: \"r\" for rock\t\"p\" for paper\t\"s\" for scissor")

for i in range(5):
    comp = random.choice([-1, 0, 1])
    a = input("Enter your choice: ")

    if a not in dict: #this will determine that entered character(in a) is present in the dict or not
        print("Invalid choice, try again.")
        continue

    you = dict[a]
    print(f"You have selected {revDict[you]}\nComputer has selected {revDict[comp]}")

    if comp == you:
        print("It's a draw")
    elif (comp == -1 and you == 0) or (comp == 0 and you == 1) or (comp == 1 and you == -1):
        print("You win!")
    else:
        print("Computer wins!")
    print("-" * 20)
