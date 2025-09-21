#tell the line number in which the "python" word is there in "C9P6.py" problem

with open("C9P6log.txt") as f:
    lines=f.readlines()
lineNo=1
for line in lines:
    if("python" in line):
        print(f"'python' is present at line number {lineNo}")
        break
    lineNo +=1
else:
    print("'python' not present")