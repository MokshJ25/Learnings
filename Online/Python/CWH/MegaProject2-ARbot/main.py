import pyautogui #Allows to control mouse, keyboard, screenshots, gui automations
import time #used to create time related tasks in the programs
import pyperclip #Used for cut, copy, and paste from or to clipboard
from openai import OpenAI #used to integrate AI (from openai) in our program
from dotenv import load_dotenv #reads key-value paor from ".env" file
import os #(operatiing system) interact with the os (creating, removing, managing, etc. files and directories
import tkinter as tk #Creates GUIs. offers buttons, pop-ups, labels, textboxes
from tkinter import messagebox #used to create message window.

#---------------------------------------------------------------------------------------------

load_dotenv()
aiAPI=os.getenv("aiAPI")

#----------------------------------------------------------------------------------------------

def aiProcess(c):
    client = OpenAI(api_key=aiAPI)
    completion=client.chat.completions.create(
    model="gpt-4o-mini",
    messages= [
        {"role": "system", "content": "You are a person named 'Moksh Jain', who speaks hindi as well as english, you are from India. you analyze the chats and reply with the next chat response(as you are Moskh), nothing else. reply generally in very short and in humanized way. strictly, Do NOT include timestamps, usernames, or any meta information."},
        {"role": "user", "content": c}
    ])

    return (completion.choices[0].message.content)


def show_popup(message, duration=2):
    popup = tk.Tk()
    popup.title("")
    popup.geometry("300x100")
    popup.eval('tk::PlaceWindow . center')
    popup.attributes('-topmost', True)
    popup.resizable(False, False)
    
    label = tk.Label(popup, text=message, font=("Segoe UI", 10), wraplength=280, justify="center")
    label.pack(expand=True, fill='both', padx=10, pady=10)
    
    popup.after(duration*1000, popup.destroy)
    popup.mainloop()

#------------------------------------------------------------------------------------------------------------------

pyautogui.click(410, 745)
#"click()" (method) moves the cursor to the argumented coordinates and click left
time.sleep(0.4)
#"sleep()" (method) waits for specified seconds
pyautogui.click(595, 660)
time.sleep(0.4)
pyautogui.moveTo(510, 170)
#"moveTo()" (method) moves the mouse cursor to the specified coordinates
pyautogui.dragTo(700, 700, duration=0.8, button='left')
#"dragTo()" (method) drags the cursor to specified coordinates in specified "duration" and by clicking specified "button"
pyautogui.hotkey('ctrl', 'c')
#"hotkey()" (method) can pass several key strings(pressed down in order and then released in reverse order)
time.sleep(1)
pyautogui.click(685, 690)
# pyautogui.click(1250,20)
time.sleep(1)
chat_history=pyperclip.paste()
#"paste()" (method) of pyperclip module pastes the latest content present in the clipboard

#Generating response
response=aiProcess(chat_history)

#Pasting the reply
pyperclip.copy(response)
time.sleep(0.5)
pyautogui.click(685, 690)
pyautogui.hotkey('ctrl', 'v')
time.sleep(1)

#------------------------------------------------------------------------------------------------------------

#popup confirmnation
root = tk.Tk()                     
root.withdraw()                    

send_confirm = messagebox.askyesnocancel("Confirm Send", "Do you want to send this message?") 

if send_confirm is True:
    time.sleep(1)                   
    pyautogui.click(685, 690)
    pyautogui.press('enter') 
    show_popup("Message sent", duration=2)     
elif send_confirm is False:
    show_popup("Message not sent", duration=2)
else:                            
    pyautogui.click(685, 690)
    time.sleep(0.3)
    pyautogui.hotkey('ctrl', 'a')
    pyautogui.press('backspace')
    show_popup("Message deleted", duration=2)
root.destroy()                    
