//WAP to concatenate two string and convert them o uppercase:

class Challenge2_7_19_71
{
    public static void main(String[] args)
    {
        String firstName="Moksh";
        String lastName="Jain";
        String fullName= firstName + " " + lastName;
      //or fullName= firstname.concat(" ").concat(lastName);
        System.out.print(fullName.toUpperCase());
    }
}
