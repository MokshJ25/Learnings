#write a python script using class, which has two methods get_string and print_string. get_string accept a string from the user and print_string print the string in upper case.
class Abc:
    # def __init__(self,word):
    #     self.word=word
    def get_string(self):
        self.word=input("Enter the string: ")
    def print_String(self):
        print(self.word.upper())
    
# obj=Abc(" ")
obj=Abc()
obj.get_string()
obj.print_String()
        