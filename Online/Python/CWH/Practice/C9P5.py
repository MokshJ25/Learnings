#Replace "Donkey" word with "######" in the other file

words=["Donkey","blow","hooves","brays"]

with open("C9P5Censor.txt") as f:
    content=f.read()
for word in words:
    content=content.replace(word,"#"*len(word))

with open("C9P5Censor.txt", "w")as f:
    content=f.write(content)