#Create a class "Pets" from a class "Animals" and further create a class "Dog" from "Pets". Add a mathod "bark" to the class "Dog"

class Animal:
    @staticmethod #any method defined as the "@staticmethod" dont need any argumenet, not even "self"
    def eat():
        print("Animal Eats")

class Pets(Animal):
    @staticmethod
    def repr():
        print("Animal Reproduces")

class Dog(Pets):
    @staticmethod
    def bark():
        print("Dog Barks")

a=Dog()
a.bark()