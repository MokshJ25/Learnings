package in2_8.Challenge2_8_4_80;

public class Tester2_8_4_80
{
    public static void main(String[] args)
    {
        Book book = new Book();
        Magazine magazine = new Magazine();
        DVD dvd = new DVD();

        book.checkout();
        magazine.returnItem();
        dvd.checkout();
    }
}
