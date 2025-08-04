import java.util.Scanner;

class Array1_56_1
{
    public static void main(String[] args)
    {
        manual();
        userInput();
        //type 1: int[] a=new int[5];
        //type 2: int[] b={1,2,3,4,5}; //we dont have to allot size priorly in this type.
    }


    public static void manual()
    {
        // Integer array:
        System.out.println("Integer Array example in manual way: ");
        int[] a={10,20,30,40,50};
        System.out.println("size of the array is: "+a.length);
        //the below loop will be taken as "array traversal"
        System.out.println("PreDefined array is: ");
        int i=0;
        while(i<5) // we can use "a.length" instead of "5" to extract the length of our "a" array
        {
            System.out.println(a[i]);
            i++;
        }

        // String array
        System.out.println("\nString Array example in manual way: ");
        String[] strArray={"first","second","third"};
        System.out.println("size of the array is: "+strArray.length);
        System.out.println("PreDefined array is: ");
        int j=0;
        while(j<strArray.length)
        {
            System.out.println(strArray[j]);
            j++;
        }
    }

    public static void userInput()
    {
        System.out.println("\nArray example with user's input: ");
        Scanner input=new Scanner(System.in);
        System.out.print("How many digits you want to enter? ");
        int q=input.nextInt();
        System.out.println("Enter "+q+" numbers: ");
        int[] b = new int[q];

        int i=0;
        while(i<q)
        {
            b[i]=input.nextInt();
            i++;
        }
        int j=0;
        System.out.println("Your entered array is: ");
        while(j<q)
        {
            System.out.print(b[j]+"\t");
            j++;
        }
    }
}
