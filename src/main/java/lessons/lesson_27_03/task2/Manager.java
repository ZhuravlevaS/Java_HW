package lessons.lesson_27_03.task2;

public class Manager extends Employee {
    private int subordinatesCount;
    public Manager(String name, String position, double salary, int subordinatesCount) {
        super(name, position, salary);
        this.subordinatesCount = subordinatesCount;
    }

    public int getSubordinatesCount() {
        return subordinatesCount;
    }

    public void setSubordinatesCount(int subordinatesCount) {
        this.subordinatesCount = subordinatesCount;
    }

    @Override
    public String toString() {
        String str = super.toString();
        return "Manager{" +
                " subordinatesCount = " + subordinatesCount +
                '}' + " " + str;
    }

    @Override
    public void calculateBonus() {
        setSalary(getSalary() + (getSalary() * 0.02 * this.subordinatesCount));
    }
}
