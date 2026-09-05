from tkinter import *
root=Tk()
root.geometry("500x500")
root.title("Learning")

l1=[]
def register():
    name=entry.get()
    l1.append(name)
    label3=Label(root,text="Name registered Successfully!").grid(row=2,column=1)
    print(l1)
    label2.configure(text=f"Welcome {name}")

#using ".get()" and ".configure()"
label1=Label(root,text="Name:")
entry=Entry(root, width=20)
button=Button(root,width=10,height=1,text="register", command=register)
label2=Label(root,text=" ")

label1.grid(row=0,column=0)
entry.grid(row=0,column=1)
button.grid(row=1,column=1)
label2.grid(row=3, column=1)


root.mainloop()