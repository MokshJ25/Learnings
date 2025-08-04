// WAP to find sum and average of elements of an array:

class Challenge2_5_1_40
{
    public static void main(String[] args)
    {
        int[] array= TakeArrayInput.input1DArray();
        int size=array.length;
        int sum=addition(array, size);
        System.out.println("Sum os the array is: "+sum);
        double ans= (double) sum /size; /* yaha integer se integer divide ho raha tha isiliye answer bhi integer
                                           me hi aa raha tha, isilie divide karne par jo answer aaya usko hamne
                                           double pe explicitly cast kar dia */
        System.out.print("Average of your array is: "+ans);
    }


    public static int addition(int[] array,int size)
    {
        int extra=0;
        int i=0;
        while(i<size)
        {
            extra+=array[i];
            i++;
        }
        return extra;
    }
}


/* In "Challenge2-5_34_40" or "2_5_34_40Challenge" we have done a new thing. We have made a separate Java
class file called "HelperTakeArrayInput.java" or "TakeArrayInput", which will facilitate us not to write
the code again and again to take input from our array. In the helper file, instead of writing
"public static void main(String[] args)", we have written "public static int[] function_name()" and then
in the function, rest of our code. The "static" will help us to call this function, present in different files,
by using the class_name and the function_name. After making "HelperTakeArrayInput" file this way, we can call
this array in "2_5_34_40Challenge" by declaring type, creating variable to store the array and calling
class_name.function_name, i.e., in "Challenge2_5_34_40" or "2_5_34_40Challenge" we have done it like:
"int[] array = TakeArrayInput.InputArray()"
 */
