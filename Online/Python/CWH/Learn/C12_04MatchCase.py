def test123(num):
    match num:
        case 101:
            return "Greater than 100"
        case 99:
            return "Smaller than 100"
        case 51:
            return "Greater than 50"
        case 49:
            return "Smaller than 50"
        case _:
            return "Invalid"
print(test123(101))
print(test123(99))
print(test123(51))
print(test123(49))
print(test123(11))