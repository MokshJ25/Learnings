#WAP to check whether two files are identical or not

with open("C9P9Helper1.txt") as f1:
    content1=f1.read()
with open("C9P9Helper2.txt") as f2:
    content2=f2.read()

if(content1==content2):
    print("They are identical")
else:
    print("They are NOT identical")
