#Calculate the cube

from tkinter import *
root1=Tk()
root1.geometry("500x500")
root1.title("Cube of a number")

def cube():
    a=int(entry.get())
    cu=a*a*a
    label2.configure(text=f"Cube is: {cu}")

label1=Label(root1, text="Enter the number")
entry=Entry(root1, width=10)
button=Button(root1, text="Calculate cube", width=10, height=1, command=cube)
label2=Label(root1, text=" ")

label1.grid(row=0, column=0)
entry.grid(row=0, column=1)
button.grid(row=1, column=1)
label2.grid(row=2, column=1)

root1.mainloop()