#Replace "Donkey" word with "######" in the other file

word="Donkey"

with open("C9P4Donkey.txt") as f:
    content=f.read()
contentNew=content.replace(word,"######")

with open("C9P4Donkey.txt", "w")as f:
    content=f.write(contentNew)