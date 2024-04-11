package lessons.lesson_08_04_enum.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Employee {
    private String name;
    private int age;
    private double salary;
    private Department department;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}
