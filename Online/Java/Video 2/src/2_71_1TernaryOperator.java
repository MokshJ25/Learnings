import java.util.Scanner;

class TernaryOperator
{
    public static void main(String[] args)
    {
        int greatestNumber;
        Scanner input= new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int num1=input.nextInt();
        System.out.print("Enter number 1: ");
        int num2=input.nextInt();

        greatestNumber=num1>num2 ? num1 : num2;
        System.out.println(greatestNumber+" is your Greatest number");
    }
}
/* -> Ternary operator is the replacement for our "if" condition.
   -> syntax for ternart operator is:-> condition ? expression1 : expression2;
      where "condition" is thee condition we put in "if". "expression1" is the expression which we want
      to execute when our "condition" is true, and "expression2" is the expression which we want to execute
      when our "condition" is false.
   -> yaha "expression1", or "expression2" ka type wahi hona chahiye jo variable ka type hai jisme wo ternary
      operator store ho raha hai (obviously), i.e., here "greatestNUmber".
   -> "condition" ka type hamesha boolean hoga and it must gigve answer either true of false.
   -> we can use nested ternary (ternary ke andar ternary) also in our code, but it gets very complicated.*/
