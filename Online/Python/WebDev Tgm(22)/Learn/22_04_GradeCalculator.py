s1=int(input("Enter Marks for subject 1: "))
s2=int(input("Enter Marks for subject 2: "))
s3=int(input("Enter Marks for subject 3: "))
s4=int(input("Enter Marks for subject 4: "))
s5=int(input("Enter Marks for subject 5: "))


total=s1+s2+s3+s4+s5
per=(total/500)*100

if(s1<35 or s2<35 or s3<35 or s4<35 or s5<35):
    print("FAIL")
elif(s1>100 or s2>100 or s3>100 or s4>100 or s5>100):
    print("Invalid Marks")

else:
    if (total<=500 and total>=0):
        print("Total Marks:", total)
        print("Percentage:", per)
    else:
        print("Invalid Marks")

    if(per<=100 and per>=0):
        if per>=90:
            print("Grade: A")
        elif (per>=80 and per<90):
            print("Grade: B")
        elif (per>=70 and per<80):
            print("Grade: C")
        elif (per>=60 and per<70):
            print("Grade: D")
        elif (per>=50 and per<60):
            print("Grade: E")
        elif(per>=40 and per<50):
            print("Grade: F")
