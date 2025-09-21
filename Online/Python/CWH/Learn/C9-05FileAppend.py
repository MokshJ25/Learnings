a="\nI Guess, you are at right place"
f=open("C9-05Demo.txt","a+") #here "a+" sets the mode to append+read. we can use "a" also for only append
f.write(a)
f.seek(0) #we nedd to do this because after apeending, the cursor will be at the end
print(f.read())