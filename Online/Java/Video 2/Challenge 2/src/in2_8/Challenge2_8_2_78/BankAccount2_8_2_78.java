package in2_8.Challenge2_8_2_78;

public class BankAccount2_8_2_78
{
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount2_8_2_78(String accountNumber, String accountHolderName)
    {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
    }

    public void depositMoney(double money)
    {
        if(money<=0)
        {
            System.out.println("Invalid deposit");
        }
        else
        {
            balance += money;
        }
    }
    public void withdrawMoney(double money)
    {
        if(money>balance)
        {
            System.out.println("Insufficient Balance");
        }
        else if (money<=0)
        {
            System.out.println("Incorrect amount entered!");
        }
        else
        {
            balance -= money;
        }
    }
    public double getBalance()
    {
        return balance;
    }
}
