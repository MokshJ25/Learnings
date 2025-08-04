package in2_8.Challenge2_8_2_78;

public class Tester2_8_2_78
{
    public static void main(String[] args)
    {
        BankAccount2_8_2_78 account=new BankAccount2_8_2_78("001","Moksh Jain");
        account.depositMoney(100);
        account.depositMoney(-40);
        account.withdrawMoney(200);
        account.withdrawMoney(10);
        account.withdrawMoney(-50);
        System.out.printf("%f",account.getBalance());
    }
}
