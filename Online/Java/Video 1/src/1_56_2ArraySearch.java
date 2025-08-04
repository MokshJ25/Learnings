import java.util.Scanner;

class ArraySearch1_56_2
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the number you want to search in the predefined array: ");
        int num=input.nextInt();
        boolean ans=elementSearch(num);
        if(ans)
        {
            System.out.println("Element Found");
        }
        else
        {
            System.out.println("Element NOT found");
        }
    }


    public static boolean elementSearch(int ele)
    {
        int[] a={0,5,10,15,20,25,30,35,40,45,50};
        int i=0;
        while(i<a.length)
        {
            int j=a[i];
            if(ele==j)
            {
                return true;
            }
            i++;
        }
        return false;
    }
}
