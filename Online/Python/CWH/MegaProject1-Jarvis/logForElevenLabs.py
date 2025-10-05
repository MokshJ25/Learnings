import requests

API_KEY = 'sk_f333cac3958376cff8e441724c17040b4681d92bb17d45e4'
url = 'https://api.elevenlabs.io/v1/voices'
headers = {'xi-api-key': API_KEY}

response = requests.get(url, headers=headers)
data = response.json()  # response is a dict

# 'voices' key contains the list of voice dictionaries
voices = data.get('voices', [])

for voice in voices:
    print(f"Voice ID: {voice['voice_id']}, Name: {voice['name']}")


'''
Voice ID: CwhRBWXzGAHq8TQ4Fs17, Name: Roger
Voice ID: EXAVITQu4vr4xnSDxMaL, Name: Sarah
Voice ID: FGY2WhTYpPnrIDTdsKH5, Name: Laura
Voice ID: IKne3meq5aSn9XLyUdCD, Name: Charlie
Voice ID: JBFqnCBsd6RMkjVDRZzb, Name: George
Voice ID: N2lVS1w4EtoT3dr4eOWO, Name: Callum
Voice ID: SAz9YHcvj6GT2YYXdXww, Name: River
Voice ID: TX3LPaxmHKxFdv7VOQHJ, Name: Liam
Voice ID: Xb7hH8MSUJpSbSDYk0k2, Name: Alice
Voice ID: XrExE9yKIg1WjnnlVkGX, Name: Matilda
Voice ID: bIHbv24MWmeRgasZH58o, Name: Will
Voice ID: cgSgspJ2msm6clMCkdW9, Name: Jessica
Voice ID: cjVigY5qzO86Huf0OWal, Name: Eric
Voice ID: iP95p4xoKVk53GoZ742B, Name: Chris
Voice ID: nPczCjzI2devNBz1zQrb, Name: Brian
Voice ID: onwK4e9ZLuTAKqWW03F9, Name: Daniel
Voice ID: pFZP5JQG7iQjIQuC4Bku, Name: Lily
Voice ID: pqHfZKP75CvOlQylNhV4, Name: Bill 
'''