package lessons.lesson_27_03.task2;

public class Developer extends Employee {
   private String programmingLanguage;

    public Developer(String name, String position, double salary, String programmingLanguage) {
        super(name, position, salary);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String toString() {
        String str = super.toString();
        return "Developer{" +
                "programmingLanguage='" + programmingLanguage + '\'' +
                '}' + " " + str;
    }
    @Override
    public void calculateBonus() {
        setSalary(getSalary() + 500);
    }
}
