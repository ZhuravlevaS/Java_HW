package lessons.lesson_17_04;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public class Circle extends Figure {
    private Color color;
    private int radius;
}
