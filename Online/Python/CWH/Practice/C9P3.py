#WAP to generate table from 2 to 20 and write it to the different files. place these files in a folder

def GenTable(n):
    table="" #its an empty string
    for i in range(1,11):
        table+=f"{n} X {i} = {n*i}\n"
    with open(f"C9P3Tables/table_{n}.txt", "w") as f:
        f.write(table)

for i in range(2,21):
    GenTable(i)