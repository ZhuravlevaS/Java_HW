package lessons.lesson_08_04_enum.task;

public enum Department {
    ACCOUNTING(0, "Accounting"),
    DEVELOPMENT(1, "Developing"),
    HR(2, "Human resources");
    int number;
    String name;

    Department(int number, String name) {
        this.number = number;
        this.name = name;
    }
}
