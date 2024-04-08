package lessons.lesson_08_04_enum.task;

import com.github.javafaker.Faker;

public class Company {

    static private Faker faker = new Faker();
    static public Employee[] employees = {
            new Developer(faker.name().fullName(), 39, 10000, Department.DEVELOPMENT, "JAVA" ),
            new Developer(faker.name().fullName(), 25, 5000, Department.DEVELOPMENT, "TypeScript" ),
            new Manager(faker.name().fullName(), 25, 5000, Department.HR, 4),
            new Manager(faker.name().fullName(), 55, 8000, Department.ACCOUNTING, 6),
            new Manager(faker.name().fullName(), 30, 4000, Department.HR, 1)
    };
}
