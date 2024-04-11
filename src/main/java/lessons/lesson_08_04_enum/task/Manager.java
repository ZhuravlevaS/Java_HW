package lessons.lesson_08_04_enum.task;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Manager extends Employee {
    private int managedEmployees;

    public Manager(String name, int age, double salary, Department department, int managedEmployees) {
        super(name, age, salary, department);
        this.managedEmployees = managedEmployees;
    }

    @Override
    public String toString() {
        String str = super.toString();
        return str + " Manager{" +
                "managedEmployees=" + managedEmployees +
                '}';
    }
}
