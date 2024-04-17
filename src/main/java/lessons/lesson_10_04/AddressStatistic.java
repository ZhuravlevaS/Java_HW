package lessons.lesson_10_04;

import java.util.LinkedList;
import java.util.List;

public class AddressStatistic {
    public static void main(String[] args) {
        int arrayLength = 10;
        List<Person> array = MockData.createMockArray(arrayLength);

        for (Person person : array) {
            System.out.println(person.getAuto().toString());
        }
        init(array);
    }

    public static void init(List<Person> array) {
        // Вывести всех лиц, живущих в домах, номера которых заканчиваются на "5".
        printHousesEnd5(array);

        // Вывести список лиц, проживающих в квартирах (номер квартиры не равен 0).
        printFlatPeople(array);

        //Найти лиц, проживающих не в своей стране (предполагая, что есть поле гражданства в классе Person).
        printNonResidents(array);

        // Вывести список лиц, у которых нет автомобилей и живут в квартирах.
        printNonCarInFlat(array);

        // Найти лиц, живущих на одной улице, но в разных домах.
       printOneStreetDiffHouses(array, array.get(MockData.random.nextInt(array.size())).getAddress().getStreet());
    }

    // Вывести всех лиц, живущих в домах, номера которых заканчиваются на "5".
    private static void printHousesEnd5(List<Person> array) {
        for (Person person : array) {
            char[] chars = person.getAddress().getHouseNumber().toCharArray();
            if (chars[chars.length - 1] == '5') {
                System.out.println("в домах, номера которых заканчиваются на \"5\": " + person);
            }
        }
    }

    // Вывести список лиц, проживающих в квартирах (номер квартиры не равен 0).
    private static void printFlatPeople(List<Person> array) {
        for (Person person : array) {
            if (!person.getAddress().isHouse()) {
                System.out.println("Живет в квартире " + person);
            }
        }
    }


    //Найти лиц, проживающих не в своей стране (предполагая, что есть поле гражданства в классе Person).
    private static void printNonResidents(List<Person> array) {
        for (Person person : array) {
            if (!person.getCitizenship().equals(person.getAddress().getCountry())) {
                System.out.println("проживающий не в своей стране " + person);
            }
        }
    }

    // Вывести список лиц, у которых нет автомобилей и живут в квартирах.

    private static void printNonCarInFlat(List<Person> array) {
        for (Person person : array) {
            if (!person.getAddress().isHouse() && person.getAuto() == null) {
                System.out.println("нет автомобилей и живут в квартирах " + person);
            }
        }
    }

    // Найти лиц, живущих на одной улице, но в разных домах.
    private static void printOneStreetDiffHouses(List<Person> array, String street) {
        LinkedList<Person> arraySameStreet= new LinkedList<>();
        for (Person person: array) {
            if(person.getAddress().getStreet().equals(street)) {
                arraySameStreet.add(person);
            }
        }

        for (int j = 0; j < arraySameStreet.size(); j++) {
            for (int i = 0; i < arraySameStreet.size(); i++) {

                String houseJ = arraySameStreet.get(j).getAddress().getHouseNumber();
                String houseI = arraySameStreet.get(i).getAddress().getHouseNumber();
                if(houseJ.equals(houseI)) {
                    arraySameStreet.remove(i);
                }
            }
        }
        for (Person person: arraySameStreet){
            System.out.println(" живущих на одной улице " + street + " , но в разных домах." + person);
        }

    }
}
