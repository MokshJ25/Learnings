
import pyautogui
import time
import pyperclip
from openai import OpenAI
from dotenv import load_dotenv
import os
import tkinter as tk
from tkinter import messagebox

#---------------------------------------------------------------------------------------------
load_dotenv()
aiAPI = os.getenv("aiAPI")
#----------------------------------------------------------------------------------------------

def aiProcess(c):
    client = OpenAI(api_key=aiAPI)
    completion = client.chat.completions.create(
        model="gpt-4o-mini",
        messages=[
            {"role": "system", "content": "You are a person named 'Moksh Jain', who speaks Hindi as well as English, you are from India. You analyze the chats and reply with the next chat response (as you are Moksh), nothing else. Reply generally in very short and in humanized way. Strictly, do NOT include timestamps, usernames, or any meta information."},
            {"role": "user", "content": c}
        ])
    return completion.choices[0].message.content

def selectText():
    pyautogui.moveTo(510, 170)
    pyautogui.dragTo(700, 680, duration=0.8, button='left')
    pyautogui.hotkey('ctrl', 'c')
    time.sleep(1)
    pyautogui.click(700, 650)
    time.sleep(1)
    chat_history = pyperclip.paste()
    return chat_history

def show_popup(message, duration=2):
    popup = tk.Tk()
    popup.title("")
    popup.geometry("300x100")
    popup.eval('tk::PlaceWindow . center')
    popup.attributes('-topmost', True)
    popup.resizable(False, False)
    label = tk.Label(popup, text=message, font=("Segoe UI", 10), wraplength=280, justify="center")
    label.pack(expand=True, fill='both', padx=10, pady=10)
    popup.after(duration * 1000, popup.destroy)
    popup.mainloop()

# --- FIXED FUNCTION: CHECK IF LAST MESSAGE IS FROM YOU --- ### <-- EDITED/ADDED
def is_last_message_from_moksh(chat_log):
    lines = [line.strip() for line in chat_log.split("\n") if line.strip()]
    if not lines:
        return False

    last_line = lines[-1]

    # Now check if last message line contains your name after timestamp
    if "] Moksh Jain:" in last_line:
        return True  # ✅ Last message is from you
    else:
        return False  # ❌ Last message is from someone else


#------------------------------------------------------------------------------------------------------------------
pyautogui.click(410, 745)
time.sleep(0.4)
pyautogui.click(595, 660)
time.sleep(0.4)

# --- MAIN LOOP --- ### <-- EDITED/ADDED
while True:

    chats=selectText()

    # --- CHECK LAST MESSAGE --- ### <-- EDITED/ADDED
    if not is_last_message_from_moksh(chats):  # ✅ Only respond if last message NOT from you
        pyautogui.click(685, 690)
        
        response = aiProcess(chats)

        # Pasting the reply
        pyperclip.copy(response)
        time.sleep(4)
        pyautogui.click(1300, 690)
        pyautogui.hotkey('ctrl', 'v')
        time.sleep(1)

        # popup confirmation
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
        time.sleep(10)
        continue

    else:  # ✅ If last message is yours, skip generating and wait
        time.sleep(4)
        continue
