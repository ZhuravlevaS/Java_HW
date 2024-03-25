package homeworks.homework_25_03;

import java.util.Arrays;
import java.util.Objects;

public class PartThree {
    public static void main(String[] args) {
        String[] array = new String[] {"word", "hallo", "bye"};
        String word = "halo";
        //    Найдите самую длинную строку в массиве строк.
        System.out.println("самая длинная строка в массиве строк: " + getMaxString(array));
        //    12: Подсчитайте, сколько раз в массиве встречается строка, равная заданной.
        System.out.println("Слово "+ word +" встречается: " + getRepStr(array, word) + " раз");
        //    13: Проверьте, все ли строки в массиве имеют одинаковую длину.
        System.out.println("Длинна строк в массиве " + Arrays.toString(array) + (checkLengthStr(array) ? " одинаковая" : " разная"));
        // 14: Найдите строку в массиве, содержащую наибольшее количество гласных.
        System.out.println("Строка с большинством гласных: " + getMaxVowelStr(array));
//          15: Сформируйте новую строку, повторяя каждую строку в массиве столько раз, какова ее длина
        System.out.println("Строка из массива" + Arrays.toString(array) + " " + getBigStr(array));
    }
//    Найдите самую длинную строку в массиве строк.
    private static String getMaxString(String[] array) {
        String maxStr = array[0];

        for (String s : array) {
            if (s.length() > maxStr.length()) {
                maxStr = s;
            }
        }

        return maxStr;
    }
//    12: Подсчитайте, сколько раз в массиве встречается строка, равная заданной.
    private static int getRepStr(String[] array, String elem) {
        int count = 0;

        for (String s : array) {
            if (Objects.equals(s, elem)) {
                count++;
            }
        }

        return count;
    }

//    3: Проверьте, все ли строки в массиве имеют одинаковую длину.
    private static boolean checkLengthStr(String[] array) {

        if(array.length == 1) {
            return  true;
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i].length() != array[i-1].length()) {
                return false;
            }
        }
        return true;

    }
//    14: Найдите строку в массиве, содержащую наибольшее количество гласных.
    private static String getMaxVowelStr(String[] array) {
        int count = 0;
        String str = "";
        for (String s : array) {
            int vowelCount = getCountVowel(s);
            if (vowelCount > count) {
                count = vowelCount;
                str = s;
            }
        }

        return str;
    }

    private static int getCountVowel(String str) {
        char[] array = str.toLowerCase().toCharArray();
        int count = 0;
        for (char c : array) {
            switch (c) {
                case 'a', 'e', 'i', 'o', 'u', 'y':
                    count++;
                    break;
            }
        }
        return count;
    }
//    15: Сформируйте новую строку, повторяя каждую строку в массиве столько раз, какова ее длина
    private static StringBuilder getBigStr(String[] array) {
        StringBuilder str = new StringBuilder();
        for (String s : array) {
            char[] charArray = s.toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                str.append(s);
            }
        }
        return str;
    }
}
