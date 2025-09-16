a="MokshJain"

#LENGTH using len() function
print("length of the string is:",len(a))  #we can use "len(var_name)" to get the length of the string

#POSITIVE STRING SLICING
b=a[0:5] #in this, the last index is not included
print("Sliced string is:",b)

#FINDING CHARACTER AT SPECIFIC INDEX
print("We have",a[5],"as our 6th character in",a) #we can use "var_name[index_number]" to get the character

#NEGATIVE SLICING
c=a[-4:-1] #Negative slicing. Last index still not included (we will get "Jai")
print("Using negative slicing on another part, we get:",c)

#BY DEFAULT VALUES AT SLICING
print("Default demo1:",a[:5]) #it is same as "a[0:5]"
print("Default demo2:",a[0:]) #it is same as "a[0:(length)]"

#SKIP SLICING
print("Skip Sliced string when skipped by 2:",a[0:5:2]) #starts with 0, ends at 5(not included) and skip 2
