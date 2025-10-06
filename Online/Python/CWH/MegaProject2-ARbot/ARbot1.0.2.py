import pyautogui
import time
import pyperclip
from openai import OpenAI
from dotenv import load_dotenv
import os
import tkinter as tk

#---------------------------------------------------------------------------------------------
load_dotenv()
aiAPI = os.getenv("aiAPI")
#----------------------------------------------------------------------------------------------

def aiProcess(c):
    client = OpenAI(api_key=aiAPI)
    completion = client.chat.completions.create(
        model="gpt-4o-mini",
        messages=[
            {"role": "system", "content": "You are a person named 'Moksh Jain', who speaks hindi as well as english, but types generally in english alphabets, rarely in devnagri. you are from India. you analyze the chats between person(s) one you(Moksh Jain) and other(s). reply with the next chat response(as you are Moksh), nothing else. reply generally in very short and in humanized way. strictly, Do NOT include timestamps, usernames, or any meta information."},
            {"role": "user", "content": c}
        ])
    return completion.choices[0].message.content


def selectText():
    
    pyautogui.moveTo(510, 170)
    pyautogui.dragTo(700, 690, duration=0.8, button='left')
    time.sleep(0.5)

    pyautogui.hotkey('ctrl', 'c')
    time.sleep(1)  # give enough time for clipboard to update
    pyautogui.click(700,650)
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


def is_last_message_from_moksh(chat_log):
    lines = [line.strip() for line in chat_log.split("\n") if line.strip()]
    if not lines:
        return True
    last_line = lines[-1]
    if "] Moksh Jain:" in last_line:
        return True
    else:
        return False


def countdown_send_popup():
    root = tk.Tk()
    root.title("Auto Send Confirmation")
    root.geometry("320x140")
    root.eval('tk::PlaceWindow . center')
    root.attributes('-topmost', True)
    root.resizable(False, False)

    countdown_time = 4
    label = tk.Label(root, text=f"Message will be sent automatically in {countdown_time} seconds.",
                     font=("Segoe UI", 10), wraplength=280, justify="center")
    label.pack(expand=True, fill='both', padx=10, pady=10)

    cancelled = {"value": False}

    def cancel_action():
        cancelled["value"] = True
        root.destroy()

    cancel_button = tk.Button(root, text="Cancel", command=cancel_action, width=10)
    cancel_button.pack(pady=5)

    def update_countdown():
        nonlocal countdown_time
        if countdown_time > 0:
            label.config(text=f"Message will be sent automatically in {countdown_time} seconds.\nClick Cancel to stop.")
            countdown_time -= 1
            root.after(1000, update_countdown)
        else:
            root.destroy()

    update_countdown()
    root.mainloop()
    return not cancelled["value"]


#------------------------------------------------------------------------------------------------------------------
# Initial clicks to focus WhatsApp
pyautogui.click(410, 745)
time.sleep(1.0)
pyautogui.click(595, 660)
time.sleep(1.0)

# --- MAIN LOOP ---
while True:
    chats = selectText()
    
    # Save chat content safely
    with open("chat_dumpyard.txt", "w", encoding="utf-8") as f:
        f.write(chats)
    
    print(chats)  # debug

    if not is_last_message_from_moksh(chats):
        pyautogui.click(685, 690)
        time.sleep(0.5)

        response = aiProcess(chats)
        time.sleep(0.5)  # small buffer after AI generates

        # Pasting the reply
        pyperclip.copy(response)
        time.sleep(1)
        pyautogui.click(1300, 690)
        time.sleep(0.5)
        pyautogui.hotkey('ctrl', 'v')
        time.sleep(1)

        # --- AUTO SEND COUNTDOWN POPUP ---
        should_send = countdown_send_popup()

        if should_send:
            pyautogui.click(685, 690)
            time.sleep(0.5)
            pyautogui.press('enter')
            time.sleep(1)
            show_popup("Message sent!", duration=1)
        else:
            pyautogui.click(685, 690)
            time.sleep(0.5)
            pyautogui.hotkey('ctrl', 'a')
            time.sleep(0.3)
            pyautogui.press('backspace')
            time.sleep(0.3)
            show_popup("Message cancelled", duration=1)

        time.sleep(5)  # wait before next iteration
        continue
    else:
        time.sleep(5)  # slower check to reduce CPU usage on old PC
        continue
