//WAP for Course class of a course management system:

import java.util.Scanner;

class Course
{
    //PROPERTIES:
    static int maxCapacity;
    int studentCount;
    String courseName;
    String[] enrolledStudents;
    boolean isEnrolled;

    //CONSTRUCTOR(s):
    Course(String courseName)
    {
        this.courseName=courseName;
        studentCount=0;
        enrolledStudents=new String[maxCapacity];
    }

    //METHOD(s):
    public static void setMaxCapacity(int maxCapacity)
    {
        Course.maxCapacity=maxCapacity;
    }

    public void enrollStudent(String studentName)
    {
        if (studentCount < maxCapacity)
        {
            enrolledStudents[studentCount] = studentName;
            studentCount++;
            System.out.println(studentName + " enrolled successfully");
        }
        else
        {
            System.out.println("Cannot enroll " + studentName + ", course is full!");
        }
    }

    public void unenrollStudent(String studentName)
    {
        System.out.println(studentName + " unenrolled successfully");
        studentCount--;
    }
// we have not really removed the unenrolled student doing this, we have just decreased the studentCount
/* to really delete the student from the array we have to do the following code:
public void unenrollStudent(String studentName)
{
    int i = 0;
    boolean found = false;

    // Find the student
    while (i < studentCount)
    {
        if (enrolledStudents[i].equals(studentName))
        {
            found = true;
            break;
        }
        i++;
    }

    if (found)
    {
        // Shift remaining students left
        int j = i;
        while (j < studentCount - 1)
        {
            enrolledStudents[j] = enrolledStudents[j + 1];
            j++;
        }
        enrolledStudents[studentCount - 1] = null; // Remove last duplicate
        studentCount--;
        System.out.println(studentName + " unenrolled successfully");
    }
    else
    {
        System.out.println(studentName + " is not enrolled in this course.");
    }
}
*/

    public static void main(String[] args)
    {
        Course DS=new Course("dataScience");
        Course.setMaxCapacity(100);
        DS.enrollStudent("Moksh");
        DS.enrollStudent("Ginni");
        DS.enrollStudent("Aadish");
        DS.unenrollStudent("Aadish");
        System.out.println(DS.studentCount);
        System.out.println(Course.maxCapacity);

        Course SA=new Course("statics");
        DS.enrollStudent("Moksh");
        DS.enrollStudent("Ginni");
        DS.enrollStudent("Aadish");
        DS.unenrollStudent("Ginni");
        System.out.println(SA.studentCount);
        System.out.println(Course.maxCapacity);
    }
}
