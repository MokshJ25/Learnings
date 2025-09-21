#WAP to mine a log file and find out the whether it contains "python"

with open("C9P6log.txt") as f:
    data=f.read()

if "python" in data:
    print("Python word is present")
else:
    print("Not present")
