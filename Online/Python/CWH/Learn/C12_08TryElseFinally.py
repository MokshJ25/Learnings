try:
    a=int(input("Enter the number: "))
    print(a)
except Exception as e:
    print(e)
else:
    print("We are inside else")
finally:
    print("We are inside finally")

print("Thanks")
