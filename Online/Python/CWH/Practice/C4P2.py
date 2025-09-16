#Accept  the marks of 6 students and display in sorted manner

marks=[]
m1=int(input("Enter mark 1: "))
marks.append(m1)
m2=int(input("Enter mark 2: "))
marks.append(m2)
m3=int(input("Enter mark 3: "))
marks.append(m3)
m4=int(input("Enter mark 4: "))
marks.append(m4)
m5=int(input("Enter mark 5: "))
marks.append(m5)
m6=int(input("Enter mark 6: "))
marks.append(m6)
marks.sort()
print("Sorted order of marks is:", marks)