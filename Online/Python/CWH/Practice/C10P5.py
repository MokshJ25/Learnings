#Create Train class which has methods to book a ticket, get status(no of seats), and get a fair information of train running under Indian Railways

from random import randint

class Train:
    def __init__(self, trainNo):
        self.trainNo=trainNo

    def book(self, fro, to):
        print(f"Your train({self.trainNo}) is booked from {to} to {fro}")
    
    def getStatus(self):
        print(f"{randint(1,25)} seats are vacant in {self.trainNo}\nTrain is on time")
    
    def getFare(self, fro, to):
        print(f"Fare for train:{self.trainNo}\tfrom: {fro}\tto: {to}\tis: {randint(200,5000)}")

train=int(input("Enter train number: "))
f=input("From:")
t=input("To:")

obj1=Train(train)
obj1.book(f,t)
obj1.getStatus()
obj1.getFare(f,t)