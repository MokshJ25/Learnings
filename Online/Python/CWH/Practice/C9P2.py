'''The game() function in a program lets a user play a ga,e and returms the scpre as an integer. You need to
   read a file "C9P2HighScore.txt" which is either blank or conains the previous highscore.
   WAP to update the highscore whenever the game() function breaks the highscore'''

import random

def game():
    print("You are playing a game...")
    score=random.randint(1,100)

    #Fetch the hoghscore:
    with open("C9P2HighScore.txt") as f:
        highscore=f.read()
        if(highscore!=""):
            highscore=int(highscore) #If the file has some number, convert it from str to int bcz file's content is readed in the form of string
        else:
            highscore=0 #If the file is empty, set highscore = 0, because we need to compare it with minimum
        
    print(f"Your score: {score}")
    if(score>highscore):
        #Write this score to the file
        with open("C9P2HighScore.txt","w") as f:
            f.write(str(score)) #here we have converted "score" int str because write deals with strings only
    
    return score

game()