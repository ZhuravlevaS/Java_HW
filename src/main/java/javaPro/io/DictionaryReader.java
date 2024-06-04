package javaPro.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictionaryReader {
    public static Map<String, String> read(String pathStr) throws IOException {
        Path path = Path.of(pathStr);
        if (path.toFile().isDirectory() || !path.toFile().exists()) {
            throw new IllegalArgumentException("wrong path");
        }

        List<String> list = Files.readAllLines(path);

        return parse(list);
    }

    private static Map<String, String> parse(List<String> list) {
        Map<String, String> result = new HashMap<>();

        for (String s : list) {
            String key = s.substring(0, s.indexOf(" "));
            String value = s.substring(s.lastIndexOf(" ") + 1);

            result.put(key, value);
        }

        return result;
    }

    private DictionaryReader() {
    }
}
