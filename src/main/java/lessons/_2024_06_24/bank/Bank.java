package lessons._2024_06_24.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Bank {
    private static List<BankAccount> bankAccountList = new ArrayList<>();

    public synchronized void transfer(int fromAccountId, int toAccountId, double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount cannot be negative");
        }

        Optional<BankAccount> bankAccountFrom = bankAccountList.stream()
                .filter(b-> b.getAccountId() == fromAccountId)
                .findFirst();

        Optional<BankAccount> bankAccountTo = bankAccountList.stream()
                .filter(b-> b.getAccountId() == toAccountId)
                .findFirst();

        if(bankAccountFrom.isPresent() && bankAccountTo.isPresent()) {
            bankAccountFrom.get().withdraw(amount);
            bankAccountTo.get().deposit(amount);
        }
    }

    public Bank() {
        for (int i = 0; i < 10; i++) {
            bankAccountList.add(new BankAccount(i, 100.00));
        }

    }
}
