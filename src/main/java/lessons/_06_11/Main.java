package lessons._06_11;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    private static final Faker faker = new Faker();
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(generateUser());
        }
    }
    private static User generateUser() {
        return new User(faker.name().fullName(), faker.number().numberBetween(5, 80));
    }

    private static Optional<User> findUser(String name, List<User> users) {
       return users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst();
    }

}
