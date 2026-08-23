f=open("22_10_01_HelperFile.txt","r")
data=f.read()
f.close()
print("Successfully copied the data")

f=open("22_10_02_HelperFile.txt","w")
f.write(data)
f.close()
print("Data successfully written to the new file")