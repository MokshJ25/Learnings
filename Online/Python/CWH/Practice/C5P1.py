#Create a dictionary of hindi words with their english values

dict={"seb":"apple","kela":"banana","phool":"flower","khush":"happy"}
print(dict.keys())
word=(input("enter the word from the above words: "))
print(f"Meaning of {word} is:{dict[word]}")