package lessons.lesson_10_04;

import java.util.Arrays;

public class BankAccountStatistic {
    public static void main(String[] args) {
        int arrayLength = 10;
        Person[] array = MockData.createMockArray(arrayLength);

        for (Person person : array) {
            System.out.println(Arrays.toString(person.getBankAccounts()));
        }
        init(array);
    }

    public static void init(Person[] array) {
        //      Вывести информацию о всех лицах, у которых счет в определенной валюте превышает заданный баланс.
        printPeopleBigBalance(Currency.BITCOIN, 8000, array);

        //    Найти и вывести имена и фамилии лиц, имеющих более одного счета (предполагая наличие списка счетов).
        printPeopleWithManyAccounts(array);

        // Определить лиц с наибольшим балансом на счету.
        printMaxBalance(array, Currency.BITCOIN);

        //Найти лиц, чей счет в определенной валюте является единственным с такой валютой в массиве.
        printOnlyCurrencyBA(array, Currency.BITCOIN);

        //    Определить и вывести лицо, имеющего счет с наименьшим балансом.
        printMinBalance(array);

        //    Определить лиц с наибольшим балансом на счету.
        printMaxBalance(array);
    }

    //  Вывести информацию о всех лицах, у которых счет в определенной валюте превышает заданный баланс.
    private static void printPeopleBigBalance(Currency currency, double limitBalance, Person[] array) {
        for (Person person : array) {
            for (BankAccount bankAccount : person.getBankAccounts()) {
                if (bankAccount.getCurrency() == currency && bankAccount.getBalance() > limitBalance) {
                    System.out.println("Слишком много деняк у " + person);
                }
            }
        }
    }

    //    Найти и вывести имена и фамилии лиц, имеющих более одного счета (предполагая наличие списка счетов).
    private static void printPeopleWithManyAccounts(Person[] array) {
        for (Person person : array) {
            if (person.getBankAccounts().length > 1) {
                System.out.println("У этого человека более одного счета: " + person);
            }
        }
    }

    // Определить лиц с наибольшим балансом на счету.
    private static void printMaxBalance(Person[] array, Currency currency) {
        Person personMaxBalance = null;
        int maxIdx = -1;
        for (Person person : array) {
            int AccIdx = getIdxAccount(person.getBankAccounts(), currency);

            if (personMaxBalance == null && AccIdx > 0) {
                personMaxBalance = person;
                maxIdx = AccIdx;
            } else if (personMaxBalance != null &&
                    maxIdx > 0 && AccIdx > 0 &&
                    personMaxBalance.getBankAccounts()[maxIdx].getBalance() < person.getBankAccounts()[AccIdx].getBalance()) {
                personMaxBalance = person;
                maxIdx = AccIdx;
            }
        }
        System.out.println("Самый большой баланс с валютой " + currency + " " + personMaxBalance);
    }

    private static int getIdxAccount(BankAccount[] bankAccounts, Currency currency) {

        for (int i = 0; i < bankAccounts.length; i++) {
            if (bankAccounts[i].getCurrency() == currency) {
                return i;
            }
        }
        return -1;
    }

    //Найти лиц, чей счет в определенной валюте является единственным с такой валютой в массиве.
    private static void printOnlyCurrencyBA(Person[] array, Currency currency) {
        for (Person person : array) {
            int countBA = 0;
            for (BankAccount bankAccount : person.getBankAccounts()) {
                if (currency.equals(bankAccount.getCurrency())) {
                    countBA++;
                }
            }
            if (countBA == 1) {
                System.out.println("счет в определенной валюте является единственным с такой валютой в массиве " + person);
            }
        }
    }
//    Определить и вывести лицо, имеющего счет с наименьшим балансом.

    private static void printMinBalance(Person[] array) {
        Person personWithMinBalance = null;
        int idxMinAcc = 0;

        for (Person person : array) {
            if (personWithMinBalance == null) {
                personWithMinBalance = person;
                idxMinAcc = findIdxMinAcc(person.getBankAccounts());
            } else {
                int idxMinCurrent = findIdxMinAcc(person.getBankAccounts());

                if (personWithMinBalance.getBankAccounts()[idxMinAcc].getBalance() > person.getBankAccounts()[idxMinCurrent].getBalance()) {
                    personWithMinBalance = person;
                    idxMinAcc = idxMinCurrent;
                }
            }
        }
        System.out.println("счет с наименьшим балансом: index:" + idxMinAcc + " min acc, person:" + personWithMinBalance);

    }

    private static int findIdxMinAcc(BankAccount[] bankAccounts) {
        double min = bankAccounts[0].getBalance();
        int idx = 0;

        for (int i = 0; i < bankAccounts.length; i++) {
            if (min > bankAccounts[i].getBalance()) {
                min = bankAccounts[i].getBalance();
                idx = i;
            }
        }

        return idx;
    }

    //    Определить лиц с наибольшим балансом на счету.
    private static void printMaxBalance(Person[] array) {
        Person personWithMaxBalance = null;
        int idxMaxAcc = 0;

        for (Person person : array) {
            if (personWithMaxBalance == null) {
                personWithMaxBalance = person;
                idxMaxAcc = findIdxMaxAcc(person.getBankAccounts());
            } else {
                int idxMinCurrent = findIdxMaxAcc(person.getBankAccounts());

                if (personWithMaxBalance.getBankAccounts()[idxMaxAcc].getBalance() < person.getBankAccounts()[idxMinCurrent].getBalance()) {
                    personWithMaxBalance = person;
                    idxMaxAcc = idxMinCurrent;
                }
            }
        }
        System.out.println("счет с наибольшим балансом: index:" + idxMaxAcc + " min acc, person:" + personWithMaxBalance);

    }

    private static int findIdxMaxAcc(BankAccount[] bankAccounts) {
        double max = bankAccounts[0].getBalance();
        int idx = 0;

        for (int i = 0; i < bankAccounts.length; i++) {
            if (max < bankAccounts[i].getBalance()) {
                max = bankAccounts[i].getBalance();
                idx = i;
            }
        }

        return idx;
    }
}
