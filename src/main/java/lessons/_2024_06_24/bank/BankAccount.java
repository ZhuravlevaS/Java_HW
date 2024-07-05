package lessons._2024_06_24.bank;

public class BankAccount extends Thread {
    private int accountId;
    private double balance;

    public int getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public synchronized void setBalance(double balance) {
        this.balance = balance;
    }

    public synchronized void withdraw(double amount) {
        if(balance < amount) {
            throw new IllegalArgumentException("amount cannot be less balance");
        } else if (amount < 0){
            throw new IllegalArgumentException("amount cannot be negative");
        }

        setBalance(balance - amount);
    }

    public synchronized double deposit(double amount) {
        if (amount > 0) {
            setBalance(amount);
            return balance;
        } else {
            throw new IllegalArgumentException("amount cannot be 0 or less");
        }
    }

    public BankAccount(int accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }
}
