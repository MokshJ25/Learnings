#Make the copy of a file

with open("C9P8Helper.txt") as f:
    content=f.read()

with open("C9P8Helper_copy.txt","w") as f:
    f.write(content)
