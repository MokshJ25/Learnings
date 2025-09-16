#Implementos module and take the list of any directory

import os
directory_path='/users/hp/desktop' #it already is in c drive, add further path. (it indicates to desktop)
contents=os.listdir(directory_path)
# for item in contents:
#     print(item)
print(contents)