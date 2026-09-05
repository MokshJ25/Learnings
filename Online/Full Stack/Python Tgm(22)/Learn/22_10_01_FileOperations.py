#Write operation in the file
f=open("22_10_01_HelperFile.txt","w") #Create/fetch the file in/from the root directory and opens it in write mode only
f.write("Date is : 12th Aug. 2026")
f.close() #will close the file and refresh the mode of the file, also it will commit the changes made to the file and save it permanently in the root directory

#Read operation in the file
f=open("22_10_01_HelperFile.txt","r") #Open the file in read mode only
print(f.read())
f.close()

#Append operation in the file
f=open("22_10_01_HelperFile.txt","a") #Open the file in append mode
f.write(" and Day is : Wednesday") 
f.close()

