package lessons.lesson_10_04;

public class AdressStatistic {
    public static void main(String[] args) {
        int arrayLength = 10;
        Person[] array = MockData.createMockArray(arrayLength);

        for (Person person : array) {
            System.out.println(person.getAuto().toString());
        }
        init(array);
    }

    public static void init(Person[] array) {
        // Вывести всех лиц, живущих в домах, номера которых заканчиваются на "5".
        printHousesEnd5(array);

        // Вывести список лиц, проживающих в квартирах (номер квартиры не равен 0).
        printFlatPeople(array);

        //Найти лиц, проживающих не в своей стране (предполагая, что есть поле гражданства в классе Person).
        printNonResidents(array);

        // Вывести список лиц, у которых нет автомобилей и живут в квартирах.
        printNonCarInFlat(array);
    }

    // Вывести всех лиц, живущих в домах, номера которых заканчиваются на "5".
    private static void printHousesEnd5(Person[] array) {
        for (Person person : array) {
            char[] chars = person.getAddress().getHouseNumber().toCharArray();
            if (chars[chars.length - 1] == '5') {
                System.out.println("в домах, номера которых заканчиваются на \"5\": " + person);
            }
        }
    }

    // Вывести список лиц, проживающих в квартирах (номер квартиры не равен 0).
    private static void printFlatPeople(Person[] array) {
        for (Person person : array) {
            if (!person.getAddress().isHouse()) {
                System.out.println("Живет в квартире " + person);
            }
        }
    }


    //Найти лиц, проживающих не в своей стране (предполагая, что есть поле гражданства в классе Person).
    private static void printNonResidents(Person[] array) {
        for (Person person : array) {
            if (!person.getCitizenship().equals(person.getAddress().getCountry())) {
                System.out.println("проживающий не в своей стране " + person);
            }
        }
    }

    // Вывести список лиц, у которых нет автомобилей и живут в квартирах.

    private static void printNonCarInFlat(Person[] array) {
        for (Person person : array) {
            if (!person.getAddress().isHouse() && person.getAuto() == null) {
                System.out.println("нет автомобилей и живут в квартирах " + person);
            }
        }
    }
}
