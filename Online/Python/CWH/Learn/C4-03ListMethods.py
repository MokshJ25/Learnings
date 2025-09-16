a = [2, 1, 7, 8, 15, 21]

a.sort()
print("After sort:", a)

a.reverse()
print("After reverse:", a)

a.append(8)
print("After append:", a)

a.insert(3, 88888)
print("After insert:", a)

popped = a.pop(2) #it rerturns the popped element
print("Popped element:", popped)
print("After pop:", a)

a.remove(21)
print("After remove:", a)

#etc....