f=open("C9-04Demo.txt")

line=f.readline()
while(line!=""): # "" show the empty string (it will continue till we dont get an empty string)
    print(line)
    line=f.readline()