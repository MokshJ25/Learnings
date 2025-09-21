#find the word "twinkle" in the poem (in C6P1Poem.txt)

f=open("C9P1Poem.txt")
data=f.read()
f.close()
if "twinkle" in data:
    print("poem contains 'twinkle'")
else:
    print("poem doesnt contains 'twinkle'")
