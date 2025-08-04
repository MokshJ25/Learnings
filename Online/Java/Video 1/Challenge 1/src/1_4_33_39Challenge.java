//WAP to print * patterns:

import java.util.Scanner;

class Challenge1_4_33_39
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int limitRow=input.nextInt();
        normalPyramid(limitRow);
        invertedPyramid(limitRow);
        mirrorPyramid(limitRow);
        centerPyramid(limitRow);
    }


    public static void normalPyramid(int limitRow)
    {
        System.out.println("Here is your \"*\"'s normal pyramid: \n");
        int row=1;
        while(row<=limitRow)
        {
            System.out.print("*");
            int i=1;
            while(i<row)
            {
                System.out.print(" *");
                i++;
            }
            System.out.println();
            row++;
        }
    }

    public static void invertedPyramid(int limitRow)
    {
        System.out.println("\nHere is your \"*\"'s inverted pyramid:");
        int row=1;
        while(row<=limitRow)
        {
            System.out.print("*");
            int i=1;
            while(i<limitRow)
            {
                System.out.print(" *");
                i++;
            }
            System.out.println();
            limitRow--;
        }
    }

    public static void mirrorPyramid(int limitRow)
    {
        System.out.println("\nHere is your \"*\"'s mirror pyramid:");
        int row=limitRow;
        while(row>0)
        {
            //this loop is to print spaces( )
            int j=0;
            while(j<row-1)
            {
                System.out.print("  ");//if we will put only 1 space here then it will become center pyramid
                j++;
            }

            //this loop is to print stars(*):
            int i=0;
            while(i<=(limitRow-row))
            {
                System.out.print("* ");
                i++;
            }
            System.out.println();
            row--;
        }
    }

    public static void centerPyramid(int limitRow)
    {
        System.out.println("\nHere is your \"*\"'s mirror pyramid:");
        int row=limitRow;
        while(limitRow>=1)
        {
            //this loop is to print spaces( )
            int j=1;
            while(j<=limitRow)
            {
                System.out.print(" "); //if we will put 2 spaces here then it will become mirror pyramid
                j++;
            }

            //this loop is to print stars(*):
            int i=0;
            while(i<=(row-limitRow))
            {
                System.out.print("* ");
                i++;
            }
            System.out.println();
            limitRow--;
        }
    }
}


/*
// may be a raw logic for mirror pyramid:
int row=1;
        while(row<=limitRow)
        {
            System.out.print(" ");
            int pointer=limitRow;
            if(pointer>=(limitRow-2))
            {
                System.out.println(" *");
                pointer++;
                System.out.println();
            }
            row++;
        }
 */