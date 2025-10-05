#Store the multiplication table generated in C12P3.py in the file named C12P5Helper.txt

n = int(input("Enter the number: "))

table=[n*i for i in range(1,11)]
print(table)

with open("C12P5Helper.txt","a") as t:
    t.write(f"Table of {n}: {str(table)}\n")