package lessons._05_17_summery.bankAcc;
//Создайте проект.
//1 Создайте класс BankAccount для банковской программы, который хранит данные о балансе счёта и методы для снятия и пополнения счёта.
//2 Создайте пакет exception. В пакете создайте два класса исключений:
//checked-исключение InsufficientFundsException (потомок Exception или его потомка).
//unchecked-исключение IncorrectAccountOperationException (потомок RuntimeException или его потомка).
//3 Метод снятия бросает InsufficientFundsException, когда снимаемая сумма больше остатка по счёту.
// Метод пополнения бросает IncorrectAccountOperationException, когда переданная сумма меньше или равна 0.
public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.addToBalance(27.50);
        System.out.println(bankAccount.getBalance());
    }
}
