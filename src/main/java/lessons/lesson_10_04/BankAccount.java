package lessons.lesson_10_04;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BankAccount {
    private Currency currency;
    private double balance;
    private int accountNumber;

    @Override
    public String toString() {
        return "BankAccount{" +
                "currency=" + currency +
                ", balance=" + balance +
                ", accountNumber=" + accountNumber +
                '}';
    }
}
