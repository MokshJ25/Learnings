import java.util.Scanner;

class Switch
{
    public static void main(String[] args)
    {
        Scanner input= new Scanner(System.in);
        System.out.print("Enter the day's number: ");
        int day=input.nextInt();
        oldSwitch(day);
        newSwitch(day);
    }

    public static void oldSwitch(int day)
    {
        System.out.println("oldSwitch() method is in execution:");
        switch (day)
        {
            case 1: // yaha check ho raha hai ki if day==1
                System.out.println("Monday");
                break; // if yaha "break" nahi laga to "1" dalne pe chize tab tak chalegi untill "break" nahi milta
            case 2: // yaha check ho raha hai ki if day==2
                System.out.println("Tuesday");
                break;
            case 3: // yaha check ho raha hai ki if day==3
                System.out.println("Wednesday") ;
                break;
            case 4: // yaha check ho raha hai ki if day==4
                System.out.println("Thursday") ;
                break;
            case 5: // yaha check ho raha hai ki if day==5
                System.out.println("Friday") ;
                break;
            case 6: //yaha break nahi to "6" daalne pe "7" wala print hoga("Holiday"). it is called "Fall through"
            case 7:
                System.out.println("Holiday") ;
                break;
            default:
                System.out.println("Invalid day");
        }
    }
    public static void newSwitch(int day)
    {
        System.out.println("newSwitch() method in execution:");
        String output= switch(day)
        {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6, 7 -> "Holiday"; // instead of old fall through, we can put "," between values to return same values
            default -> "Invalid day";
        };
        System.out.println(output);
    }
}
