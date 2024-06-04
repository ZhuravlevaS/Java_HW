package lessons._05_31;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// !!!Прочитайте файл и посчитайте средний рейтинг всех стримов. Запишите результат в новый файл.
// Отфильтруйте стримы, имеющие рейтинг выше 4.5, и запишите их в новый файл.
// Сгруппируйте стримы по названию и запишите количество стримов в каждой группе в новый файл.
// Отсортируйте стримы по рейтингу от наибольшего к наименьшему и запишите результаты в новый файл.
public class Reader {

    public static Map<String, List<Double>> streamsToRatings = new HashMap<>();
    public static Map<String, Double> streamToAverage;

    public static void main(String[] args) {
        valueGetter("1: [Стрим 65], 4.0");

        read();
//        System.out.println(getAvgRating());
       System.out.println(streamsToRatings);

        writeToFile("avg.txt", "Average rating of all rates: " +getAvgRating(), true);
    }

    public static void read() {
        String path = "f.txt";

        List<String> lines = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(path))) {
            while (fileReader.readLine() != null) {
                String line = fileReader.readLine();
                String key = keyGetter(line);
                Double value = valueGetter(line);
                if (key != null && value != null) {
                    List<Double> list = streamsToRatings.getOrDefault(key, new ArrayList<>());
                    list.add(value);
                    streamsToRatings.put(key, streamsToRatings.getOrDefault(key, list));
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeToFile(String fileName, String line, Boolean append) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, append))) {
            writer.write(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Double valueGetter(String line) {
        Pattern pattern = Pattern.compile("\\d+\\.\\d+");
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {

            return Double.parseDouble(matcher.group(0));  // Выводит: подстрокой
        }

        return null;
    }

    private static String keyGetter(String line) {
        Pattern pattern = Pattern.compile("\\d+:\\s*\\[([^\\]]+)\\]");
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            return matcher.group(1);  // Выводит: подстрокой
        }

        return null;
    }

    private static Double getAvgRating() {
        return streamsToRatings
                .entrySet()
                .stream()
                .flatMap((el) -> el.getValue().stream())
                .mapToDouble(el -> el)
                .average()
                .getAsDouble();
    }
}
