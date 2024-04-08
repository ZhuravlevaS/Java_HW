package lessons.lesson_08_04_enum.task;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Developer extends Employee {
    String programmingLanguage;

    public Developer(String name, int age, double salary, Department department, String programmingLanguage) {
        super(name, age, salary, department);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String toString() {
        String str = super.toString();
        return str + " Developer{" +
                "programmingLanguage='" + programmingLanguage + '\'' +
                '}';
    }
}
