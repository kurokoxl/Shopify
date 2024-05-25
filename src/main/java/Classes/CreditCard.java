package Classes;

public class CreditCard{
    private double balance=5000;
    private int id;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void pay(double amount) {
            balance -= amount;
    }
    public void refund(double amount) {
            balance += amount;
    }

}
