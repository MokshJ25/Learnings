#Create two classes Employee and Manager. The Employee class has the following attributes: member_id, name, department, and salary. The Manager class inherits from the Employee class and has an additional attribute called bonus. Implement a method in the Manager class to display the information of the manager, including their member_id, name, department, salary, and bonus.

class Employee:
    def __init__(self, member_id, name, department, salary):
        self.member_id=member_id
        self.name=name
        self.department=department
        self.salary=int(salary)
     
class Manager(Employee):
    def __init__(self,member_id, name, department, salary, bonus):
        super().__init__(member_id, name, department, salary)
        self.bonus=int(bonus)
    def display_info(self):
        print("Member ID:",self.member_id)
        print("Name:",self.name)
        print("Department:",self.department)
        print("Salary:",self.salary)
        print("Bonus:",self.bonus)


mng1=Manager(102, "Moksh", "Manager", 100000, 20000)
mng2=Manager(103, "Kush", "Manager", 90000, 20000)
mng3=Manager(104, "Tanmay", "Manager", 80000, 20000)
mng4=Manager(105, "Aalok", "Manager", 70000, 20000)

mng1.display_info() 
