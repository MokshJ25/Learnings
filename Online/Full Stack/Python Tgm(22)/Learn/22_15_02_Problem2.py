#Count the number of characters in a string but make GUI

from tkinter import *
win=Tk()
win.geometry("350x100")
win.title("Find the occurance of a character")

def cnt():
    str=entry1.get().lower()
    c=entry2.get().lower()
    num=0

    for i in str:
        if(i==c):
            num=num+1
    label3.configure(text=f"Character {c} is occuring {num} times in {str}")



label1=Label(win, text="Enter the string").grid(row=0,column=0)
label2=Label(win, text="Enter the character").grid(row=1,column=0)
entry1=Entry(win,width=20)
entry2=Entry(win,width=10)
button=Button(win,text="Find!", command=cnt, width=5, height=1).grid(row=2, column=1)
label3=Label(win,text="")

entry1.grid(row=0, column=1)
entry2.grid(row=1, column=1)
label3.grid(row=3, column=1)

win.mainloop()