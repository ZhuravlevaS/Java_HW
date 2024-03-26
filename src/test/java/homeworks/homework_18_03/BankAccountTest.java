package homeworks.homework_18_03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    @Test
    void isValidAccountNumberPositive() {
        String accountNumber = "12345678901234";
        assertTrue(BankAccount.isValidAccountNumber(accountNumber));
    }
    @ParameterizedTest
    @ValueSource(strings = { "00000000000000", "123456789012340" })
    @NullSource
    @EmptySource
    void isValidAccountNumberNegative(String accountNumber) {
        assertFalse(BankAccount.isValidAccountNumber(accountNumber));
    }
}