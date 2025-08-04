class StringFormatting
{
    public static void main(String[] args)
    {
        String name="Moksh";
        int salary =1234567890;
        System.out.println(name+", your Marks are: "+ salary+"\n");

        //instead of using this concatenation, we can use formatting, i.e.:
        /* Syntax for screen formatting:
           "%" + Flag + width + precision + specifier character */
        //for String(%s):
        System.out.printf("%s, your Salary is: %d \n", name, salary);
        System.out.printf("%S, your Salary is: %d \n", name, salary);//Convert string in uppercase
        System.out.printf("%10s, your Salary is: %d \n", name, salary);//reserve space of 10 for string(from right)
        System.out.printf("%-10s, your Salary is: %d \n", name, salary);//start from left with 10 place reserved
        //for integer(%d):
        System.out.printf("%s, your Salary is: %d \n", name, salary);
        System.out.printf("%s, your Salary is: %15d \n", name, salary);//reserve space of 15 for integer(from right)
        System.out.printf("%s, your Salary is: %015d \n", name, salary);//pad with 0 if space remains in 15 space(")
        System.out.printf("%s, your Salary is: %+15d \n", name, salary);//add +ve sign on string, 15 space reserved(")
        System.out.printf("%s, your Salary is: %-15d \n", name, salary);//shifts number to left, " " "
        System.out.printf("%s, your Salary is: %0,15d \n", name, salary);//add "0" pad,add +ve sign, "," b/w 3, """(")
        System.out.printf("%s, your Salary is: %+,15d \n", name, salary);//add +ve sign, "," b/w 3 integers, " " "(")
        System.out.printf("%s, your Salary is: %-+,15d \n", name, salary);//shifts to left, " " ", " " ", " " "
    }
}
