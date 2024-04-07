package homeworks.homework_18_03;


import java.util.Objects;

public class BankAccount {
    private static final int ACCOUNT_NUMBER_LENGTH = 14;
    private static final String INVALID_ACCOUNT = "00000000000000";
    public static void main(String[] args) {
        String accountNumber = "12345678901234";
        System.out.println(isValidAccountNumber(accountNumber));
    }
    public static boolean  isValidAccountNumber(String accountNumber) {
        if(accountNumber != null &&
                accountNumber.length() == ACCOUNT_NUMBER_LENGTH &&
                !Objects.equals(INVALID_ACCOUNT, accountNumber)) {
            return true;
        }

        return false;
    }
}
