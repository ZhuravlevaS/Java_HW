package lessons.lesson_17_04;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class RadiusInfo {
    private int radiusSum = 0;
    private int circleSum = 0;

    public int getAverageRadiusSum() {
        if(circleSum != 0 ){
            return radiusSum/circleSum;
        }

        return 0;
    }

    public void sumRadius(int radius) {
        radiusSum += radius;
    }

    public void incrementCircle() {
        circleSum += 1;
    }
}
