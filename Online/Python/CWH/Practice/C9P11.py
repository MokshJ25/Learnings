#WAP to Rename a file in python (here, C9P11Helper.txt to C9P11Renamed.txt)

import os #os module is used to handel the file related operations

with open("C9P11Helper.txt") as f:
    content=f.read()
with open("C9P11Renamed.txt","w") as f:
    f.write(content)

os.remove("C9P11Helper.txt") #It deleted the exixting file