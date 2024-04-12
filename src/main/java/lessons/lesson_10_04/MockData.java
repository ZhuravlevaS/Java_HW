package lessons.lesson_10_04;

import com.github.javafaker.Faker;

import java.util.Random;

public class MockData {
    public static Person[] createMockArray(int arrayLength){
        Random random = new Random();
        Faker faker = new Faker();

        Person[] array = new Person[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            Country[] countries = Country.values();
            CarBrand[] carBrands =  CarBrand.values();
            Color[] colors = Color.values();
            Currency[] currencies = Currency.values();

            int bankAccLength = faker.number().numberBetween(1, 10);
            BankAccount[] bankAccounts = new BankAccount[bankAccLength];

            for (int j = 0; j < bankAccLength; j++) {
                bankAccounts[j] = new BankAccount(
                        currencies[random.nextInt(currencies.length)],
                        faker.number().randomDouble(2, 2000, 10000),
                        faker.number().numberBetween(1900, 2000000)
                );
            }

            Address address = new Address(
                    countries[random.nextInt(countries.length)],
                    faker.address().streetName(),
                    faker.address().buildingNumber(),
                    faker.bool().bool(),
                    faker.number().randomDigitNotZero()
            );

            Car car = new Car(
                    carBrands[random.nextInt(carBrands.length)],
                    faker.number().numberBetween(1, 6),
                    faker.bool().bool(),
                    faker.number().numberBetween(10, 600),
                    faker.number().randomDouble(2, 2000, 10000),
                    faker.number().numberBetween(1900, 2024),
                    colors[random.nextInt(colors.length)]
            );

            array[i] = new Person(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    address,
                    faker.number().randomDouble(2, 2000, 10000),
                    car,
                    bankAccounts
            );
        }

        return array;
    }
}
