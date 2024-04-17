package lessons.lesson_17_04;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public class Triangle extends Figure {
    private Color color;
    private int side1;
    private int side2;
    private int side3;
}
