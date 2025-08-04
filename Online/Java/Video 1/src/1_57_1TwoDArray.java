import java.util.Scanner;

class TwoDArray1_57_1
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        //Type 1: int[][] a=new int[2][3];

        //Type 2: int[][] b={{1,2,3},{5,6,7}};
        int[][] b={{1,2,3},{5,6},{10,11,12}}; /* It is an example of heterogeneous array, i.e., number elements
                                                 in rows are different. */
        System.out.println("Number of rows in the array is: "+b.length);

        System.out.println("2D array is: \n");
        int i=0;
        while(i<b.length)// we can also right "b[0].length" instead of "3"
        {
            int j=0;
            while(j<b[i].length)
            {
                System.out.print(b[i][j]+"\t");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
