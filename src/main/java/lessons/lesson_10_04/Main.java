package lessons.lesson_10_04;

public class Main {
    public static void main(String[] args) {
        int arrayLength = 10;
        Person[] array = MockData.createMockArray(arrayLength);

        for (Person person : array) {
            System.out.println(person.getAuto().toString());
        }

        BankAccountStatistic.init(array);
        AdressStatistic.init(array);
        CarStatistic.init(array);
        SalaryStatistic.init(array);

    }
}
