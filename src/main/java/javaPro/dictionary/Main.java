package javaPro.dictionary;

import javaPro.io.DictionaryReader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Dictionary dictionary = new Dictionary(DictionaryReader.read("dictionary.txt"));
        System.out.println(dictionary.translate("cat"));
    }
}
