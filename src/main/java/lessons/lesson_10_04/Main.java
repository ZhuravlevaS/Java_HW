package lessons.lesson_10_04;

import com.github.javafaker.Faker;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int arrayLength = 10;
        Person[] array = MockData.createMockArray(arrayLength);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);

//            for (int j = 0; j < array[i].getBankAccounts().length; j++) {
//                System.out.println(array[i].getBankAccounts()[j].toString());
//            }
        }

//      Вывести имена и фамилии всех лиц, чьи автомобили не красные и не спортивные.
        printNames(array);

//      Найти и вывести среднюю зарплату всех лиц, проживающих в определенной стране.
        System.out.println("Средняя ЗП по " + Country.UK + ": " + countAverageSalaryCountry(Country.UK, array));

//  Вывести информацию о всех лицах, у которых счет в определенной валюте превышает заданный баланс.
        printPeopleBigBalance(Currency.BITCOIN, 8000, array);
    }


//  Вывести имена и фамилии всех лиц, чьи автомобили не красные и не спортивные.
    private static void printNames(Person[] array) {
        for (Person person: array) {
            if(!person.getAuto().isSportive() && person.getAuto().getColor() != Color.RED) {
                System.out.println("Вкус есть у этиго человека: " + person.getName() + ' ' + person.getSurname());
            }
        }
    }
//  Найти и вывести среднюю зарплату всех лиц, проживающих в определенной стране.
    private static double countAverageSalaryCountry(Country country, Person[] array) {
        double salaries = 0;
        int countPeople  = 0;

        for (Person person: array) {
            if (person.getAddress().getCountry() == country) {
                salaries += person.getSalary();
                countPeople++;
            }
        }

        return countPeople != 0 ? salaries/countPeople : 0;
    }
//  Вывести информацию о всех лицах, у которых счет в определенной валюте превышает заданный баланс.
    private static void  printPeopleBigBalance(Currency currency, double limitBalance, Person[] array) {
        for (Person person: array) {
            for (BankAccount bankAccount: person.getBankAccounts()) {
                if (bankAccount.getCurrency() == currency && bankAccount.getBalance() > limitBalance) {
                    System.out.println("Слишком много деняк у " + person.toString());
                }
            }
        }
    }
//   Перечислить всех, у кого автомобиль был выпущен до определенного года.
    private static void printPersonCarBeforeYear(Person[] array, int year) {

    }

}
