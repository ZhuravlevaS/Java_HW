package lessons.lesson_27_03.task2;

public class Task2 {
    public static void main(String[] args) {
        Manager manager = new Manager("Egor", "CTO",1000, 10);
        Developer developer = new Developer("Nataly", "Frontender", 1500, "JS");

        Employee[] array = {manager, developer};

        for (Employee employee : array) {
//            System.out.println(employee.getSalary());
//            employee.calculateBonus();
//            System.out.println(employee.getSalary());
            System.out.println(employee.toString());
        }
    }
}
