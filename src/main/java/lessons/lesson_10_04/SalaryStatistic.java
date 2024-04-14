package lessons.lesson_10_04;

public class SalaryStatistic {

    public static void main(String[] args) {
        int arrayLength = 10;
        Person[] array = MockData.createMockArray(arrayLength);

        for (Person person : array) {
            System.out.println(person);
        }

        init(array);
    }

    public static void init(Person[] array) {
        // Вывести имена лиц, у которых зарплата выше среднего по массиву.
        printPWithBigSalary(array);

        //      Найти и вывести среднюю зарплату всех лиц, проживающих в определенной стране.
        System.out.println("Средняя ЗП по " + Country.UK + ": " + countAverageSalaryCountry(Country.UK, array));

    }

    //  Найти и вывести среднюю зарплату всех лиц, проживающих в определенной стране.
    private static double countAverageSalaryCountry(Country country, Person[] array) {
        double salaries = 0;
        int countPeople = 0;

        for (Person person : array) {
            if (person.getAddress().getCountry() == country) {
                salaries += person.getSalary();
                countPeople++;
            }
        }

        return countPeople != 0 ? salaries / countPeople : 0;
    }

    // Вывести имена лиц, у которых зарплата выше среднего по массиву.
    private static void printPWithBigSalary(Person[] array) {
        double salaries = 0;
        for (Person person : array) {
            salaries += person.getSalary();
        }

        double averageSalary = salaries / array.length;

        for (Person person : array) {
            if (person.getSalary() > averageSalary) {
                System.out.println("ЗП выше средней: " + person.getName() + " " + person.getSurname());
            }
        }
    }

}
