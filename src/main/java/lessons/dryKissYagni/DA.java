package lessons.dryKissYagni;

import lessons._06_11.User;

import java.util.List;

public class DA {
    // Нарушение DRY: Дублирование кода
    public void processData(List<Integer> data) {
        int sum = 0;
        for (int num : data) {
            sum += num;
        }
        System.out.println("Sum: " + sum);

        double average = (double) sum / data.size();
        System.out.println("Average: " + average);
    }

    public void processUserData(List<Object> users) {
        int totalAge = 0;
        for (Object user : users) {
            //totalAge += user.getAge();
        }
        System.out.println("Total Age: " + totalAge);

        double averageAge = (double) totalAge / users.size();
        System.out.println("Average Age: " + averageAge);
    }
}

class DataService {
    public double getAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(d -> d)
                .average().orElse(0);
    }

    public void showAverage(List<Integer> numbers) {
        double average = getAverage(numbers);

        System.out.println("Average: " + average);
    }

    public void showAverageAge(List<User> users) {
        List<Integer> ages = users.stream()
                .map(User::getAge)
                .toList();

        double averageAge = getAverage(ages);
        System.out.println("Average Age: " + averageAge);
    }
}

