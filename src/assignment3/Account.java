package assignment3;
import java.text.NumberFormat;
import java.util.Locale;

public class Account {
    private int accountNumber;
    private double balance;

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void credit(double amount){
        balance += amount;
    }

    public int debit(double amount){
        if (balance >= amount){
            balance -=amount;
            return 1;
        }
        else{
            return 0;
        }
    }

    public int transferTo(double amount, Account another){
        if (balance >=amount) {
            another.setBalance(another.getBalance() + amount);
            balance -= amount;
            return 1;
        }
        else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return "A/C no:" + accountNumber +
                // beautify the rounded balance amount
                ", Balance=" + NumberFormat.getCurrencyInstance(new Locale("en", "US"))
                .format(Math.round(balance * 100.0) / 100.0);
    }
}

 class Main {
    public static void main(String[] args) {
        Account newAccount= new Account(5566, 0);
        System.out.println(newAccount);
        newAccount.credit(11.1);
        System.out.println(newAccount);
        newAccount.debit(5.5);
        System.out.println(newAccount);

        Account a2= new Account(5567);
        newAccount.transferTo(1.0, a2);
        System.out.println(newAccount);
//        System.out.println(a2);

    }
}
