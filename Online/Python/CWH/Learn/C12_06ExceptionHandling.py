try: #this block contains the code jo chalna chahiye or jisme error aa sakte hai
    a=int(input("Enter the number: "))
    print(a)
except Exception as e: #this will contain the ki yadi wo error aaya to kya karenge. here we haverinted that error
    print(e)
#yadi ham try wale doce me input me integer ki jagah kuch or daal denge to program crash nahi karega, wo sirf error ko screen par print kar dega. normal codes me program crash ho jata yadi ye situation aati to or aage ka program run hi nahi karta, par yaha aisa nahi hoga, yaha aage ka program(here, print statement) bhi run hoga

print("Thanks")

#NOTE: "except" wali chiz tab hi chalegi jab "try" me kuch exception aaega