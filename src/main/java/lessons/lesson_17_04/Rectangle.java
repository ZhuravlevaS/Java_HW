package lessons.lesson_17_04;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public class Rectangle extends Figure {
    private Color color;
    private int width;
    private int hight;
}
