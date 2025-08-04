//

class ForEachLoop
{
    public static void main(String[] args)
    {
        String[] array=new String[]{"Ram","Shyam","Mohan","Rohan","Sita","Geeta"};
        arrayTraversalForLoop(array);
        arrayTraversalForEachLoop(array);
    }

    public static void arrayTraversalForLoop(String[] array)
    {
        System.out.println("For loop in execution:");
        for (int i=0 ; i<array.length ; i++)
        {
            System.out.println(array[i]);
        }
    }
    public static void arrayTraversalForEachLoop(String[] array)
    {
        System.out.println("\nFor Each loop in execution:");
        for(String name:array)
        {
            System.out.println(name);
        }
    }
}
