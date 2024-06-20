package lessons.dryKissYagni;

import java.util.List;

// Нарушение CODE SMELLS:
public class DAta {
    public double calculateAverage(List<Double> numbers) {
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }

        double average = sum / numbers.size();

        double variance = 0;
        for (double num : numbers) {
            variance += Math.pow(num - average, 2);
        }
        double standardDeviation = Math.sqrt(variance / numbers.size());

        return standardDeviation;
    }
}

 class Calculator2 {
    public double calculateAverage(List<Double> numbers) {
       return numbers.stream()
               .mapToDouble(d->d)
               .average().orElse(0);
    }

    public double calculateStandardDeviation(List<Double> numbers) {
        double average = calculateAverage(numbers);

        double variance = numbers.stream()
                .reduce((acc, d)-> {
                    acc += Math.pow(d - average, 2);
                    return acc;
                }).orElse(0.0);

        return Math.sqrt(variance / numbers.size());
    }
}
