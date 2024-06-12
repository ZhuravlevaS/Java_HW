package lessons._06_10;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class StudentTest {
    private static int countId = 0;
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private  double grade;
    private Major major;
    private int year;
    private boolean isFullTime;

    private void makeId() {
        this.id = countId;
        countId++;
    }

    public StudentTest(String firstName,
                       String lastName,
                       String email,
                       double grade,
                       Major major,
                       int year,
                       boolean isFullTime) {
        makeId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.grade = grade;
        this.major = major;
        this.year = year;
        this.isFullTime = isFullTime;
    }
}
