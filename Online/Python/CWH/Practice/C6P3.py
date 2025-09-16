#WAP to detect the spam comments

a=input("Enter the comment: ")

if(("Make a lot of money" in a) or ("click this" in a) or ("buy now" in a) or ("subscribe this" in a)):
    print("!!!Spam!!!")
else:
    print("Not Spam!")