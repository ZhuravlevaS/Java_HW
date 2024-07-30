package kostianoiia;

import com.fasterxml.jackson.databind.ObjectMapper;
import kostianoiia.dto.WidgetDto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        String jsonStr = Files.readString(Path.of("ParseMe.json"));
        System.out.println("Иcходный json");
        System.out.println(jsonStr);
        ObjectMapper mapper = new ObjectMapper();
        WidgetDto widget = mapper.readValue(jsonStr, WidgetDto.class);
        System.out.println();
        System.out.println("Итоговый объект");
        System.out.println(widget);
    }
}