package lessons.lesson_27_03.task1;

public class Auto extends Vehicle {
    String engineType;
    public Auto(String name, int speed, String engineType) {
        super(name, speed);
        this.engineType = engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getEngineType() {
        return engineType;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "engineType='" + engineType + '\'' +
                '}';
    }
}

