class Parent:
    def p(self):
        print("This is parent's method")
class Child(Parent):
    def c(self):
        print("This is child's method")

child_obj=Child()
child_obj.c()
child_obj.p()#by inheriting, we can access the parent's methods also 