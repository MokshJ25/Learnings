f=open("C9-03Demo.txt")
data1=f.readline() #this will print first line as the cursor is in the starting
data2=f.readline() #this will print second line as the cursor is at the end oof the first line as it is printed
data3=f.readlines() #it will give the list of the strings from 3rd line, as our cursor is at the end of line 2
print("'readline' gives : "+data1+"'readline' again give : "+data2+"'readlines' give : ",data3)
'''
"readline" prints the first line and the cursor gets on then last word of the last line(obviously).
now when we did "readlines", the cursor starts withe where it was. and will print from nect lines.
to bring cursor to the starting place, we need to use "seek(0)" '''