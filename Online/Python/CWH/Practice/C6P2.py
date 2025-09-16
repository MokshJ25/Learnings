#WAP to find whether the student passed or failed. require 40% in total and 33% in individual

a=int(input("Enter Maths marks: "))
b=int(input("Enter Science marks: "))
c=int(input("Enter English marks: "))
f1=(((a+b+c)/300)*100)


if(a>=33 and b>=33 and c>=33 and f1>=40):
    print(f"Passes in all subjects: {f1}%")
else:
    print(f"Failed in all or some subjects: {f1}%")