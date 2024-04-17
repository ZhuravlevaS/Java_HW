package lessons.lesson_10_04;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MockData {
    public static final Random random = new Random();
    public static final Faker faker = new Faker();
    public static List<Person> createMockArray(int arrayLength){


        List<Person> array = new ArrayList<>();

        String[] streets = {"A", "B"};
        String[] houseNumbers = {"1A", "2B", "5C"};
        for (int i = 0; i < arrayLength; i++) {
            Country[] countries = Country.values();
            CarBrand[] carBrands =  CarBrand.values();
            Color[] colors = Color.values();
            Currency[] currencies = Currency.values();

            int bankAccLength = faker.number().numberBetween(1, 10);
            List<BankAccount> bankAccounts = new ArrayList<>();

            for (int j = 0; j < bankAccLength; j++) {
                bankAccounts.add(new BankAccount(
                        currencies[random.nextInt(currencies.length)],
                        faker.number().randomDouble(2, 2000, 10000),
                        faker.number().numberBetween(1900, 2000000)
                ));
            }

            Address address = new Address(
                    countries[random.nextInt(countries.length)],
                    streets[random.nextInt(streets.length)],
                    houseNumbers[random.nextInt(houseNumbers.length)],
                    faker.bool().bool(),
                    faker.number().randomDigitNotZero()
            );

            Car car = new Car(
                    carBrands[random.nextInt(carBrands.length)],
                    faker.number().numberBetween(1, 6),
                    faker.bool().bool(),
                    faker.number().numberBetween(10, 600),
                    faker.number().randomDouble(2, 2000, 10000),
                    faker.number().numberBetween(1900, 2025),
                    colors[random.nextInt(colors.length)]
            );

            array.add(new Person(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    address,
                    faker.number().randomDouble(2, 2000, 10000),
                    car,
                    bankAccounts,
                    countries[random.nextInt(countries.length)]
            ));
        }

        return array;
    }
}
