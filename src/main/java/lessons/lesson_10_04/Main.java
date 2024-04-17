package lessons.lesson_10_04;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int arrayLength = 10;
        List<Person> array = MockData.createMockArray(arrayLength);

        for (Person person : array) {
            System.out.println(person.getAuto().toString());
        }

        BankAccountStatistic.init(array);
        AddressStatistic.init(array);
        CarStatistic.init(array);
        SalaryStatistic.init(array);
    }
}
