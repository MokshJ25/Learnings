#WAP to filter a list of numbers which are divisible by 5

l=[1,2,5,21,20,45,37,80,43,40]

def divByFive(n):
    if(n%5==0):
        return True
    return False

ans=list(filter(divByFive,l)) # or we can directly write "print(list(filter(divByFive,l)))"
print(ans)