package homeworks.homework_25_03.hw_27_03.utils;

import com.github.javafaker.Faker;
import homeworks.homework_25_03.hw_27_03.components.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class GenerateMockData {
    private static OfficeEquipment getOfficeEquipment(int number) {
        Faker faker = new Faker();
        Date date =  new Date(1, Calendar.JANUARY, 1);
        Date date1 =  new Date();

        switch (number) {
            case 0:
                return new Laptop(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.date().between(date, date1).getYear(),
                        faker.number().randomDouble(2, 1, 10000),
                        faker.number().randomDouble(2, 1, 10000),
                        faker.bool().bool(),
                        faker.dune().character(),
                        faker.number().randomDouble(2, 1, 10000),
                        faker.number().randomDouble(2, 1, 10000),
                        faker.number().randomDouble(2, 1, 10000),
                        faker.number().randomDouble(2, 1, 10000),
                        faker.dune().character(),
                        faker.bool().bool()
                );
            case 1:
                return new Monitor(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.date().between(date, date1).getYear(),
                        faker.number().randomDouble(2, 1, 10000),
                        faker.number().randomDouble(2, 1, 10000),
                        faker.bool().bool(),
                        faker.number().randomDouble(2, 1, 10000),
                        faker.dune().character(),
                        faker.dune().character(),
                        faker.dune().character(),
                        faker.bool().bool(),
                        faker.bool().bool(),
                        faker.dune().character()
                );
            case 2:
                return new Printer(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.date().between(date, date1).getYear(),
                        faker.number().randomDouble(2, 1, 10000),
                        faker.number().randomDouble(2, 1, 10000),
                        faker.bool().bool(),
                        faker.dune().character(),
                        faker.number().randomDigit(),
                        faker.dune().character(),
                        faker.bool().bool(),
                        faker.dune().character(),
                        faker.dune().character(),
                        faker.dune().character()
                );
            case 3:
                return new ScannerEquipment(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.date().between(date, date1).getYear(),
                        faker.number().randomDouble(2, 1, 10000),
                        faker.number().randomDouble(2, 1, 10000),
                        faker.bool().bool(),
                        faker.dune().character(),
                        faker.number().randomDigit(),
                        faker.dune().character(),
                        faker.dune().character(),
                        faker.dune().character(),
                        faker.bool().bool(),
                        faker.dune().character()
                );
            case 4:
                return new Projector(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.date().between(date, date1).getYear(),
                        faker.number().randomDouble(2, 1, 10000),
                        faker.number().randomDouble(2, 1, 10000),
                        faker.bool().bool(),
                        faker.dune().character(),
                        faker.dune().character(),
                        faker.dune().character(),
                        faker.number().randomDigit(),
                        faker.dune().character(),
                        faker.dune().character(),
                        faker.bool().bool()
                );
            case 5:
                return new Tablet(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.date().between(date, date1).getYear(),
                        faker.number().randomDouble(2, 1, 10000),
                        faker.number().randomDouble(2, 1, 10000),
                        faker.bool().bool(),
                        faker.dune().character(),
                        faker.number().randomDigit(),
                        faker.dune().character(),
                        faker.number().randomDigit(),
                        faker.bool().bool(),
                        faker.dune().character(),
                        faker.dune().character()
                );
            case 6:
                return new Phone(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.date().between(date, date1).getYear(),
                        faker.number().randomDouble(2, 1, 10000),
                        faker.number().randomDouble(2, 1, 10000),
                        faker.bool().bool(),
                        faker.dune().character(),
                        faker.number().randomDigit(),
                        faker.dune().character(),
                        faker.number().randomDigit(),
                        faker.bool().bool(),
                        faker.dune().character(),
                        faker.dune().character()
                );
            case 7:
                return new Router(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.date().between(date, date1).getYear(),
                        faker.number().randomDouble(2, 1, 10000),
                        faker.number().randomDouble(2, 1, 10000),
                        faker.bool().bool(),
                        faker.number().randomDigit(),
                        faker.dune().planet(),
                        faker.dune().planet(),
                        faker.dune().planet(),
                        faker.dune().planet(),
                        faker.bool().bool(),
                        faker.dune().planet()
                );
            case 8:
                return new Switch(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.date().between(date, date1).getYear(),
                        faker.number().randomDouble(2, 1, 10000),
                        faker.number().randomDouble(2, 1, 10000),
                        faker.bool().bool(),
                        faker.number().randomDigit(),
                        faker.number().randomDigit(),
                        faker.dune().planet(),
                        faker.dune().planet(),
                        faker.dune().planet(),
                        faker.dune().planet(),
                        faker.dune().planet()
                );
            default:
                return null;
        }
    }

    public static OfficeEquipment[] getRandomData(int lengthOfArray) {
        Random random = new Random();

        OfficeEquipment[] array = new OfficeEquipment[lengthOfArray];

        for (int i = 0; i < lengthOfArray; i++) {
            int randomNum = random.nextInt(0, 10);

            array[i] = getOfficeEquipment(randomNum);
        }

        return array;
    }
}
