class MathDemo // we cant use "Math" name for our class because "Math" class already exists in java
{
    public static void main(String[] args)
    {
        //for absolute value (modulus):
        System.out.println("abs(): "+Math.abs(-99));

        //for rounding off:
        System.out.println("ceil(): "+Math.ceil(9.01));
        System.out.println("floor(): "+Math.floor(9.01));
        System.out.println("round(): "+Math.round(9.01));
        System.out.println("round(): "+Math.round(9.51));

        //for pre defined Constants:
        System.out.println("Constants:(Pi) "+Math.PI);
        System.out.println("Constants:(E) "+Math.E);
        System.out.println("Constants:(Tau) "+Math.TAU);

        //for generating random number:
        /* "random()" is used to generate random number ranging between 0.0 to 1.0. if we want greater random numbers
            we cant multiply these random numbers by 10 or 100 or 1000 or more, but then also it will give values in
            decimal, so we can use "round()"/"floor()"/"ceil()" methods (as per requirement) of math class itself.*/
        System.out.println("random(): "+Math.random());
        System.out.println("random() : (for larger and non decimals)");
        for (int i = 0; i < 10; i++)
        {
            long random=Math.round(Math.random()*100);
            System.out.println(random);
        }
    }
}
