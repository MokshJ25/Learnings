import speech_recognition as sr #used for speech-to-text
import webbrowser #it is a built-in module
import pyttsx3 #(python text-to-speech)
import musicLibrary #it is the file we have created in our computer
import requests #makes http request. brides with webservices and APIs. it requests and get responses
from openai import OpenAI #used to integrate AI (from openai) in our program
from gtts import gTTS #(google text_to_speech) works as pyttsx3 but in better way
import pygame #handels sound, grapgics, user input. mainly used to make 2d games
import os #(operatiing system) interact with the os (creating, removing, managing, etc. files and directories
import warnings #Used to alert the user of a problem(doent cause exception or terminate the program)
from dotenv import load_dotenv #reads key-value paor from ".env" file

#---------------------------------------------------------------------------------------

warnings.filterwarnings("ignore")  # hide deprecation warnings
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"  # hide pygame startup message

#-----------------------------------------------------------------------------------------

r= sr.Recognizer() 
#"Recognizer" (class) in speech_recognition module. it helps in taking speech recognization functionality

engine=pyttsx3.init()
pyttsxVoices = engine.getProperty('voices')
engine.setProperty('voice', pyttsxVoices[1].id)
engine.setProperty('rate', 200)  #makes speech faster

load_dotenv()
newsAPI=os.getenv("newsAPI")
aiAPI=os.getenv("aiAPI")
elevenLabsAPI=os.getenv("elevenLabsAPI")
ElevenLabsVoiceID = os.getenv("ElevenLabsVoiceID")

#-----------------------------------------------------------------------------------------

def speak(text): 
    engine.say(".....")
    engine.say(text) 
    #"say()" method queues the text that you want text-to-speech engine to speak
    engine.runAndWait() 
    #"runAndWait()" blocks the execution of prog. until all queued speech command processed/spoken by t-to-s engine

def speak_from_gtts(text): 
    tts = gTTS(text=text, lang='en', slow=False)
    tts.save('audio.mp3')

    pygame.mixer.init()
    #"mixer"(module of pygame library) for loading and playing sounds
    pygame.mixer.music.load("audio.mp3")
    #"music" (module of pygame.mixer) controls the playback of music in the sound mixer. "load()" loads the MP3 file
    pygame.mixer.music.play()
    #"play()" method used to play the audio file loaded in "music.load()"

    # Keep the program running until the music stops
    while pygame.mixer.music.get_busy():
    #"get_busy()" returns a boolean value, indicating if a music file has currently been played or not
        pygame.time.Clock().tick(10)
        #"tick()" method (called once per frame) computes how many msec. have passed since the previous call
    pygame.mixer.music.unload()
    #"unload()" unloads the file
    os.remove("audio.mp3")
    #"remove()" (method) of os module which removes(deletes) a file/directory

def speak_from_elevenlabs(text):
    url = f"https://api.elevenlabs.io/v1/text-to-speech/{ElevenLabsVoiceID}"
    headers = {"xi-api-key": elevenLabsAPI, "Content-Type": "application/json"}
    data = {"text": text, "voice_id": ElevenLabsVoiceID, "output_format": "mp3"}
    # Request TTS audio
    response = requests.post(url, headers=headers, json=data)
    if response.status_code == 200:
        # Save audio file
        with open("speech.mp3", "wb") as f:
            f.write(response.content)

        # Play audio using pygame
        pygame.mixer.init()
        pygame.mixer.music.load("speech.mp3")
        pygame.mixer.music.play()

        while pygame.mixer.music.get_busy():
            pygame.time.Clock().tick(10)
        # Cleanup
        pygame.mixer.music.unload()
        os.remove("speech.mp3")
    else:
        print(f"Error {response.status_code}: {response.text}")

#--------------------------------------------------------------------------------------------

def aiProcess(c):
    client = OpenAI(api_key=aiAPI)
    completion=client.chat.completions.create(
    model="gpt-4o-mini",
    messages= [
        {"role": "system", "content": "You are a virtual assistant and partner named 'Jarvis', skilled in general tasks like alexa and googhle assistannt, but answer generally in short."},
        {"role": "user", "content": c}
    ])

    return (completion.choices[0].message.content)


def processCommand(c):
    print(c)
    if "open google" in c.lower():
        webbrowser.open("https://google.com")
        #"webbrowser" is a module and "open()" is its method, which opens the content in the default browser
    
    elif "open youtube" in c.lower():
        webbrowser.open("https://youtube.com")
    
    elif "open linkedin" in c.lower():
        webbrowser.open("https://linkedin.com")
    
    elif "open facebook" in c.lower():
        webbrowser.open("https://facebook.com")
    
    elif "play" in c.lower():
        found = False
        for song in musicLibrary.music:
            if song.lower() in c.lower():
                webbrowser.open(musicLibrary.music[song])
                found = True
                speak(f"Playing {song}")
                break
        if not found:
            speak("Song not added yet")
    
    elif "news" in c.lower():
        newsReq=requests.get(f"https://newsapi.org/v2/top-headlines?country=us&apiKey={newsAPI}")
        #"get()" method is the part of request module, which help to get the data in the APIs.
        if newsReq.status_code==200:
            data=newsReq.json()
            articles=data.get("articles",[])
            if not articles:
                speak("Sorry, I couldn't find any latest news right now.")
            else:
                speak("Here are the top headlines for today.")
                print("Here are the top headlines for today.")
                for article in articles[:5]:
                    print(f"\n{article['title']}\n")
                    speak(article['title'])
        
    elif "exit" in c.lower() or "stop" in c.lower() or "bye bye" in c.lower() or "close" in c.lower():
        speak("Goodbye Moksh!")
        exit()
    
    #Let OpenAI Handel the request:
    else:
        output = aiProcess(c)
        speak(output)


#-----------------------------------------------------------------------------------------------------------

if __name__=="__main__":
    speak("Initializing Jarvis")
    
    while True:
        # Listen for the wake word "Jarvis"       
        try:
            with sr.Microphone() as source: 
            #"Microphone()" used to capture audio directly from microphone conn. to comp.
                print("Listening...")
                audio = r.listen(source, timeout=2, phrase_time_limit=2) 
                #"listen()" (method) capture audio input from a specified audio source
            word=r.recognize_google(audio)
            #recognize_google() is a method in "speech_recognition" module, used to convert spoken audio into text using Google's speech recognition service. (we can use other services also other than google)
            ''' or we can also use:
            print("Sphinx thinks you said " + r.recognize_sphinx(audio))
            #"recognize_sphinx()" (method) enables speech recognition using the CMU Sphinx engine(open-source, lightweight speech recognition engine, for offline, low-resource speech recognition). we need to install and import "pocketsphinx" to use this '''

            print(word)
            if "jarvis" in word.lower():
                speak("Yes Moksh")
                while True:

                    #Listen for Command
                    with sr.Microphone() as source: 
                        print("Jarvis Activated...")
                        audio = r.listen(source) 
                        command=r.recognize_google(audio)
                        processCommand(command)

        except Exception as e:
            print("Error; {}".format(e))