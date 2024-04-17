package lessons.lesson_10_04;

import java.util.Date;
import java.util.List;

public class CarStatistic {
    public static void main(String[] args) {
        int arrayLength = 10;
        List<Person> array = MockData.createMockArray(arrayLength);

        for (Person person : array) {
            System.out.println(person.getAuto().toString());
        }

        init(array);
    }

    public static void init(List<Person> array) {
        //     Вывести имена и фамилии всех лиц, чьи автомобили не красные и не спортивные.
        printNonRedNonSportive(array);

        //       Перечислить всех, у кого автомобиль был выпущен до определенного года.
        printPersonCarBeforeYear(array, 1970);

        //        Вывести список всех лиц без автомобилей (предполагая, что авто может быть null).
        printNoCarPeople(array);

        //        Определить количество лиц, имеющих спортивный автомобиль с мощностью более 300 л.с.
        printWithSportiveCars(array);

        // Вывести список лиц, чьи автомобили являются наиболее мощными в своем классе (спортивные/неспортивные).
        printMaxCapacityAuto(array);

        // Найти лиц с автомобилями определенной марки и цвета.
        printPeopleAuto(array, CarBrand.MERCEDES, Color.BLUE);

        // Вывести список лиц, чьи автомобили были куплены новыми (год выпуска авто равен текущему году).
        printNewCar(array);

        // Найти лиц, у которых есть автомобиль определенного цвета, но не спортивный.
        printNonSportiveColor(array, Color.BLACK);

        // Найти и вывести лиц, чьи автомобили имеют стоимость выше заданной.
        printExpensiveCar(array, 100);

        // Вывести имена и фамилии всех лиц, чьи автомобили имеют четное количество дверей.
        printEvenDoors(array);

        // Вывести список лиц, имеющих автомобили, которые стоят дороже их зарплаты.
        printCarMoreSalary(array);

        // Определить количество лиц, у которых есть автомобили с количеством дверей больше 4.
        printMore4Doors(array);

        // Вывести список лиц, имеющих автомобиль той же марки, что и автомобиль первого лица в массиве.
        printSameBrandCar(array);

    }

    //  Вывести имена и фамилии всех лиц, чьи автомобили не красные и не спортивные.
    private static void printNonRedNonSportive(List<Person> array) {
        for (Person person : array) {
            if (!person.getAuto().isSportive() && person.getAuto().getColor() != Color.RED) {
                System.out.println("автомобили не красные и не спортивные: " + person.getName() + ' ' + person.getSurname());
            }
        }
    }

    //   Перечислить всех, у кого автомобиль был выпущен до определенного года.
    private static void printPersonCarBeforeYear(List<Person> array, int year) {
        for (Person person : array) {
            if (person.getAuto().getYearOfIssue() < year) {
                System.out.println("Машина до " + year + " года у " + person.getName() + " " + person.getSurname());
            }
        }
    }

    //    Вывести список всех лиц без автомобилей (предполагая, что авто может быть null).
    private static void printNoCarPeople(List<Person> array) {
        for (Person person : array) {
            if (person.getAuto() == null) {
                System.out.println("У человека нет машины: " + person);
            }
        }
    }

    //    Определить количество лиц, имеющих спортивный автомобиль с мощностью более 300 л.с.
    private static void printWithSportiveCars(List<Person> array) {
        int count = 0;
        for (Person person : array) {
            if (person.getAuto().isSportive() && person.getAuto().getCapacity() > 300) {
                count++;
            }
        }
        System.out.println("количество лиц, имеющих спортивный автомобиль с мощностью более 300 л.с.:" + count);
    }

    // Вывести список лиц, чьи автомобили являются наиболее мощными в своем классе (спортивные/неспортивные).
    private static void printMaxCapacityAuto(List<Person> array) {
        Person maxSportive = null;
        Person maxNonSportive = null;

        for (Person person : array) {
            if (person.getAuto().isSportive()) {
                if (maxSportive == null) {
                    maxSportive = person;
                } else if (person.getAuto().getCapacity() > maxSportive.getAuto().getCapacity()) {
                    maxSportive = person;
                }
            } else {
                if (maxNonSportive == null) {
                    maxNonSportive = person;
                } else if (person.getAuto().getCapacity() > maxNonSportive.getAuto().getCapacity()) {
                    maxNonSportive = person;
                }
            }
        }

        System.out.println("Самый мощный спортивный: " + maxSportive);
        System.out.println("Самый мощный не спортивный: " + maxNonSportive);
    }


    // Найти лиц с автомобилями определенной марки и цвета.
    private static void printPeopleAuto(List<Person> array, CarBrand carBrand, Color color) {
        for (Person person : array) {
            if (person.getAuto().getCarBrand() == carBrand && person.getAuto().getColor() == color) {
                System.out.println("Человек с машиной " + carBrand + " и цвета " + color + ": " + person);
            }
        }
    }

    // Вывести список лиц, чьи автомобили были куплены новыми (год выпуска авто равен текущему году).
    private static void printNewCar(List<Person> array) {
        for (Person person : array) {
            if (person.getAuto().getYearOfIssue() == new Date().getYear() + 1900) {
                System.out.println("Машины были куплены в этом году: " + person);
            }
        }
    }

    // Найти лиц, у которых есть автомобиль определенного цвета, но не спортивный.
    private static void printNonSportiveColor(List<Person> array, Color color) {
        for (Person person : array) {
            if (!person.getAuto().isSportive() && person.getAuto().getColor() == color) {
                System.out.println("Не спортивный автомобиль цвета " + color + " у " + person);
            }
        }
    }

    // Найти и вывести лиц, чьи автомобили имеют стоимость выше заданной.
    private static void printExpensiveCar(List<Person> array, double carPrice) {
        for (Person person : array) {
            if (person.getAuto().getPrice() > carPrice) {
                System.out.println("Машина стоимостью выше " + carPrice + " " + person);
            }
        }
    }

    // Вывести имена и фамилии всех лиц, чьи автомобили имеют четное количество дверей.
    private static void printEvenDoors(List<Person> array) {
        for (Person person : array) {
            if (person.getAuto().getDoorNumber() % 2 == 0) {
                System.out.println("четное количество дверей " + person.getName() + " " + person.getSurname());
            }
        }
    }

    // Вывести список лиц, имеющих автомобили, которые стоят дороже их зарплаты.
    private static void printCarMoreSalary(List<Person> array) {
        for (Person person : array) {
            if (person.getAuto().getPrice() > person.getSalary()) {
                System.out.println("лицо, имеющих автомобили, которые стоят дороже их зарплаты " + person);
            }
        }
    }

    // Определить количество лиц, у которых есть автомобили с количеством дверей больше 4.
    private static void printMore4Doors(List<Person> array) {
        int countCars = 0;

        for (Person person : array) {
            if (person.getAuto().getDoorNumber() > 4) {
                countCars++;
            }
        }
        System.out.println(countCars);
    }

    // Вывести список лиц, имеющих автомобиль той же марки, что и автомобиль первого лица в массиве.
    private static void printSameBrandCar(List<Person> array) {
        Person first = array.get(0);

        for (int i = 0; i < array.size(); i++) {
            if (i != 0 && first.getAuto().getCarBrand().equals(array.get(i).getAuto().getCarBrand())) {
                System.out.println("имеющий автомобиль той же марки, что и автомобиль первого лица в массиве " + array.get(i));
            }
        }
    }
}
