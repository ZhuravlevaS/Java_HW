package lessons.dryKissYagni;

import java.util.List;

public class D1 {
    public double calculateAverageValueForGivenList(List<Double> listOfNumbers) {
        double sumOfAllValues = 0;

        for (double currentValue : listOfNumbers) {
            sumOfAllValues += currentValue;
        }
        return sumOfAllValues / listOfNumbers.size();
    }
}

class Calculator1 {
    public double calculateAverage(List<Double> numbers) {
        return numbers.stream()
                .mapToDouble(d -> d)
                .average().orElse(0);
    }
}


