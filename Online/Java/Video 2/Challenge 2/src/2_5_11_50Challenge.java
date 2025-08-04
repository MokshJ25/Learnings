//WAP to find the sum of all diagonal elements in a mxm array

class Challenge2_5_11_50
{
    public static void main(String[] args)
    {
        int[][] arr=TakeArrayInput.input2DArray();

        int ans=diagonalSum(arr);
        System.out.println("\nSum of all diagonal elements of the array is: "+ans);
    }


    public static int diagonalSum(int[][]array)
    {
        int i=0, sum =0;
        System.out.print("Diagonal elements are: ");
        while(i<array.length)
        {
            int j=0;
            while(j<array[i].length)
            {
                if(i==j || (i+j == array.length-1))
                {
                    sum +=array[i][j];
                    System.out.print(array[i][j]+"  ");
                }
                j++;
            }
            i++;
        }
        return sum;
    }
}
