//WAP for Book class of a library management system:

class Book
{
    //PROPERTIES:
    static int totalBooks;
    String title;
    String author;
    String isbn; // "isbn" is an unique id of a book
    boolean isBorrowed;

    //CODE BLOCKS: (if required)
    static
    {// ye bolega ki jaise hi hamari class load ho rahi ho to us time "totalBooks" ko 0 set kar dena
        totalBooks=0;
    }

    {/* ye bolega ki jaise hi hamara kisi bhi book ka object bane waise hi "totalBooks" me 1 add ho jae
        kyuki ye wala code block har object ke sath create hoga. it canbe simply called as Object Intitializer */
        totalBooks++;
    }

    //CONSTRUCTORS(s):
    Book(String isbn, String title, String author)
    {
        this.isbn=isbn;
        this.title=title;
        this.author=author;
    }

    Book(String isbn)
    {
        this(isbn,"Unknown","Unknown");
    }

    //METHODS:
    public static int getTotalBooks()
    {
        return totalBooks;
    }
    public void borrowBook()
    {
        if(isBorrowed)
        {
            System.out.println(title+" Book is already borrowed!");
        }
        else
        {
            isBorrowed=true;
            System.out.println(title +" Book assigned successfully");
        }
    }
    public void returnBook()
    {
        if(isBorrowed)
        {
            isBorrowed=false;
            System.out.println(title+" Book returned Successfully");
        }
        else
        {
            System.out.println(title+" book is already in the library!");
        }
    }

    //main method to see all behaviours here itself
    public static void main(String[] args)
    {
        Book richDad=new Book("1","RichDadPoorDad","Robert kiyosaki");
        Book hiddenHindu=new Book("2");

        System.out.println(Book.totalBooks);
        richDad.borrowBook();
        hiddenHindu.borrowBook();
        richDad.borrowBook();
        richDad.returnBook();
        hiddenHindu.borrowBook();
        richDad.returnBook();
    }

}
