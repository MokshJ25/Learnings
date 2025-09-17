#WAP to convert Celsius to Fahrenheit using functions

def c_to_f(n):
    return (n*(9/5))+32

a=int(input("Enter the temperature in Celsius: "))
ans=c_to_f(a)
print(f"{a}°C in Fahrenheit is: {round(ans,2)}°F") #"round(ans,2)" will round the ans upto 2 decimal places 
