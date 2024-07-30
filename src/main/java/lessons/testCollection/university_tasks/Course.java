package lessons.testCollection.university_tasks;

import lombok.Getter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.Objects;

@Getter
@ToString
public class Course {
    // unique name!
    private String name;
    private LinkedList<Student> studentList;

    public void setName(String name) {
        if(!name.isEmpty()) this.name = name;
    }

    public void addStudent(Student student) {
        if (Objects.isNull(student)) {
            System.out.println("student не может быть null");
        } else {
            if(Objects.isNull(studentList)) {
                studentList = new LinkedList<>();
                studentList.add(student);
            } else {
                studentList.add(student);
            }
        }
    }

    public void removeCourse(Student student) {
        if (Objects.isNull(student)) {
            System.out.println("Курс не может быть null");
        } else {
            if(!Objects.isNull(studentList)) {
                studentList.remove(student);
            }
        }
    }

    public int getAverageAge() {
        int sum = 0;

        if (studentList.isEmpty()) {
            return 0;
        }

        for (Student student: studentList){
            sum += student.getAge();
        }

        return sum/studentList.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Course(String name, LinkedList<Student> studentList) {
        if(!name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Имя не может быть пустым!");
        }
        this.studentList = studentList;
    }
}
