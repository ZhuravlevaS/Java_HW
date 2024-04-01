package homeworks.hw_27_03.utils;

import com.github.javafaker.Faker;
import homeworks.hw_27_03.components.*;

import java.util.Date;

public class GenerateMockData {
    public OfficeEquipment[] createMockArray() {
        Faker faker = new Faker();
        Date date =  new Date(1900, 01, 01);
        Date date1 =  new Date();

        Laptop laptop = new Laptop(
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

        Monitor monitor = new Monitor(
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

        Printer printer = new Printer(
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
        Scanner scanner = new Scanner(
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
        Projector projector = new Projector(
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

        Tablet tablet = new Tablet(
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

        Phone phone = new Phone(
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

        Router router = new Router(
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

        Switch switchEquipment = new Switch(
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
        // TODO: make randomizer
        OfficeEquipment[] array = { laptop, switchEquipment, router, printer, projector, phone, monitor, scanner, tablet, switchEquipment};
        return array;
    }
}
