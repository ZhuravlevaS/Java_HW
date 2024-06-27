package algorithms;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String str = "String"; // false
        String str1 = "strrts"; // true
        String str2 = "st rirt    s!!!!!"; // true
        String str3 = "a man, a plan, da canal, panama!"; // true
        String str4 = "1"; // true

        System.out.println(isPalindrome1(str3));

    }

    private static boolean isPalindrome(String string) {
        int middleIdx = string.length() / 2;

        for (int i = 0; i < middleIdx; i++) {
            if (string.charAt(i) != string.charAt(string.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isPalindrome1(String string) {
        int i = 0;
        int j = string.length() - 1;

        List<Integer> dd = new LinkedList<>();

        while (i < j) {
            while (!Character.isLetter(string.charAt(i))) {
                i++;
            }
            while (!Character.isLetter(string.charAt(j))) {
                j--;
            }

            if (Character.isLetter(string.charAt(i)) && Character.isLetter(string.charAt(j))) {
                if (string.charAt(i) != string.charAt(j)) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            }
        }

        return true;
    }
}
