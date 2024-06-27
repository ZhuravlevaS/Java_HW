package lessons._05_17_summery.bankAcc;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BankAccount {
    private double balance;

    public BankAccount() {
        this.balance = 0.0;
    }

    public void addToBalance(double amount) {
        this.balance += amount;
    }

    public void takeFromBalance(double amount) {
        if(amount > this.balance) {

        } else {
            this.balance -= amount;
        }

    }
}
