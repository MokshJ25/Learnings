//WAP to check weather tow arrays are sorted and then merge those sorted array:
class Challenge2_5_8_47
{
    public static void main(String[] args)
    {
        System.out.println("For Array 1:");
        int[] arr1 = TakeArrayInput.input1DArray();
        System.out.println("\nFor Array 2:");
        int[] arr2 = TakeArrayInput.input1DArray();

        if (isForwardSortedArray1(arr1) && isForwardSortedArray2(arr2))
        {
            DisplayArray.display1DArray(mergingIncreasing(arr1,arr2));
        }
        else if (isBackwardSortedArray1(arr1) && isBackwardSortedArray2(arr2))
        {
            DisplayArray.display1DArray(mergingDecreasing(arr1,arr2));
        }
        else
        {
            System.out.println("Array you entered is not sorted or not sorted in same order");
        }
    }


    public static boolean isForwardSortedArray1(int[] array1)
    {
        int temp1 = array1[0];
        int extra1 = 1;
        int i = 1;
        while (i < array1.length)
        {
            if (temp1 <= array1[i])
            {
                temp1=array1[i];
                extra1++;
            }
            else
            {
                break;
            }
            i++;
        }
        return extra1 == array1.length;
    }
    public static boolean isForwardSortedArray2(int[] array2)
    {
        int temp2=array2[0];
        int extra2=1;
        int i=1;
        while(i<array2.length)
        {
            if(temp2<=array2[i])
            {
                temp2=array2[i];
                extra2++;
            }
            else
            {
                break;
            }
            i++;
        }
        return extra2 == array2.length;
    }

    public static boolean isBackwardSortedArray1(int[] array1)
    {
        int temp1 = array1[0];
        int extra1 = 1;
        int i = 1;
        while (i < array1.length)
        {
            if (temp1 >= array1[i])
            {
                temp1=array1[i];
                extra1++;
            }
            else
            {
                break;
            }
            i++;
        }
        return extra1 == array1.length;
    }
    public static boolean isBackwardSortedArray2(int[] array2)
    {
        int temp2=array2[0];
        int extra2=1;
        int i=1;
        while(i<array2.length)
        {
            if(temp2>=array2[i])
            {
                temp2=array2[i];
                extra2++;
            }
            else
            {
                break;
            }
            i++;
        }
        return extra2 == array2.length;
    }


    public static int[] mergingIncreasing(int[] array1, int[] array2)
    {
        System.out.println("Merging is being executed");
        int[] newArr = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;

        while ((i < array1.length) || (j < array2.length))
        {
            if ((j == array2.length) || (i < array1.length && array1[i] < array2[j]))
            {
                newArr[k] = array1[i];
                i++;
                k++;
            } else
            {
                newArr[k] = array2[j];
                j++;
                k++;
            }
        }
        return newArr;
    }

    public static int[] mergingDecreasing(int[] array1, int[] array2)
    {
        System.out.println("Merging is being executed");
        int[] newArr=new int[array1.length+array2.length];
        int i=0, j=0, k=0;

        while((i<array1.length)||(j<array2.length))
        {
            if((j==array2.length)||(i<array1.length && array1[i]>array2[j]))
            {
                newArr[k]=array1[i];
                i++;
                k++;
            }
            else
            {
                newArr[k]=array2[j];
                j++;
                k++;
            }
        }
        return newArr;
        /*
            here in "if" condition (condition1||((condition2.1)&&(condition2.2))
            it tells us that yadi array2 khatam ho gaya hai to "condition1" will become true therefore
            if condition will become true, to tum "if" me ghus ke "i" yani array1 ke sare bache element loop
            chala ke as it is print karwa do. lekin yadi array2 khatam nahi hua hai, i.e., "j" abhi tak array2
            ki length par nahi pohocha hai to condition 1 is false, i.e., if(0||((cond2.1)&&(cond2.2)),
            it means there are chances ki ham "else" par jae, par dekhna hai ki array1 khatam hua hai ki nahi,
            to hamne (i<array1.length) ki condition lagai hai ki yadi "i" yani array1 abhi tak khatam nahi
            hua hai, i.e. ye condition true(1) hai to "&&" ke baad wali condition check karo, i.e.
            array1[i]<array2[j], kyuki array1 bhi khatam nahi hua or array 2 bhi khatam nahi hai tab hi
            ham ye wali condition par jump kar sakte hai. yadi ye bhi true(1) hua tab hi hamara condition2
            overall true(1) hoga or ham "if" wali statement execute kar paenge.
            or yadi condition1(i.e., j==array2.length) false(0) hai, yani array2 abhi tak khatam NAHI hua
            or condition2.1(i.e., i<array1.length) bhi false(0) hai yani "i" yani array1 khatam ho gaya to
            overall condition2 false(0) ho jaegi kyuki condition2 me "&&" laga hua hai, or hamara loop else par
            pohoch jaega or "j" ke yani array2 ke sare bache elements loop chala ke as it is print karwa dega.
            in case conition1 false(0) hai yani array2 abhi tak khatam nahi hua hai or condition2.1 true hai
            yani array1 bhi abhi tak khatam nahi hua hai or hamne "&&" ke baad dekha ki condition2.2 yani
            (array1[i]<array2[j]) flase(0) hai, to bhi hamara overall if false(0) ho jaega kyuki
            ((0) || ((0) && (1)) will become 0 or else wali statements chalegi (obviously).
             */
    }
}