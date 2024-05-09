package lessons.testCollection.university_tasks;

import lombok.Getter;

import java.util.LinkedList;
import java.util.Objects;

@Getter

public class Student extends Person implements Identifiable, Descriable, CommunityMember {
    private final String studentId;
    private LinkedList<Course> courseList;

    public void addCourse(Course course) {
        if (Objects.isNull(course)) {
            System.out.println("Курс не может быть null");
        } else {
            if(Objects.isNull(courseList)) {
                courseList = new LinkedList<>();
                courseList.add(course);
            } else {
                courseList.add(course);
            }
        }
    }

    public void removeCourse(Course course) {
        if (Objects.isNull(course)) {
            System.out.println("Курс не может быть null");
        } else {
            if(!Objects.isNull(courseList)) {
                courseList.remove(course);
            }
        }
    }


    public Student(String name, String surname, int age, String studentId) {
        super(name, surname, age);
        this.studentId = studentId;
    }

    @Override
    public String toString() {

        return super.toString()   + " " + "Student{" +
                "studentId=" + studentId +
                ", courseList=" + courseList +
                '}';
    }

    @Override
    public String describe() {
        return "Это Student с именем " + super.getName() + " " + super.getSurname();
    }

    @Override
    public String getIdentity() {
        return "Student{" +
                "studentId=" + studentId +
                ", name=" + super.getName() +
                ", surnamename=" + super.getSurname() +
                '}';
    }

    @Override
    public String getCommunityStatus() {
        return Main.faker.starTrek().character();
    }
}
