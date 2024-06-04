package javaPro.dictionary;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private Map<String, String> wordToTranslation;

    public Dictionary(Map<String, String> wordToTranslation) {
        this.wordToTranslation = wordToTranslation;
    }

    public Dictionary() {
        this.wordToTranslation = new HashMap<>();
    }

    public String translate(String word) {
       return wordToTranslation.get(word);
    }

    public boolean hasTranslation(String word) {
        return wordToTranslation.containsKey(word);
    }

    public void addTranslation(String original, String translation) {
        wordToTranslation.put(original, translation);
    }
}
