from tkinter import *

win=Tk() #this will create the object of "Tk" class in tkinter module
win.geometry("500x500")#this will call the method called "geometry()" from the "Tk()" class and we will access it using its object, i.e., "win"(here) 
# geometry() is used to set the application window's size and position
#syntax for geometry(): obj_name.geometry("widthxheight+x_offset+y_offset"). ex.: root.geometry("400x300+100+50") 

win.title("Moksh") #This will provide the name to the tkinter window(on the top left corner)

##widgets in tkinter
#Label : display text or images in a tkinter window. shows messages, titles, instructions
label1=Label(win, text="Name:").grid(row=0, column=0)
label2=Label(win, text="Age:").grid(row=1, column=0)

#Entry : accepts single-line text input from the user
entry= Entry(win, width=30).grid(row=2, column=0)

def btn_check():
    print("Button clicked!")
#Button : Clickable component used to perform an action when pressed
button1=Button(win,text="click me!",width=10,height=1,command=btn_check).grid(row=3,column=0)  
#here "command" takes the function which is to be called when the button is clicked




win.mainloop() #this will call the method called "mainloop()" from "Tk" class. Mainloop
#"mainloop()" is an infinite loop event that keeps the GUI visible, responsive, and active. without this, the window will collapse in milliseconds.