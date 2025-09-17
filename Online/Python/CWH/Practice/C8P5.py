#WA function to print first n lines of given "*" pattern

def patt(n):
    if n==0:
        return
    else:
        print("*"*n)
        patt(n-1)

a=int(input("Enter the number: "))
patt(a)


'''
#other logic
def patt(n):
    temp=n
    for i in range(1,temp+1):
        print("*"*n)
        n-=1

a=int(input("Enter the number of lines: "))
patt(a)
'''