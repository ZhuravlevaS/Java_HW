package lessons.lesson_27_03.task1;

public class Bicycle extends Vehicle {
        private String bicycleType;
        public Bicycle(String name, int speed, String bicycleType) {
                super(name, speed);
                this.bicycleType = bicycleType;
        }

        public void setBicycleType(String bicycleType) {
                this.bicycleType = bicycleType;
        }

        public String getBicycleType() {
                return bicycleType;
        }

        @Override
        public String toString() {
                return "Bicycle{" +
                        "bicycleType='" + bicycleType + '\'' +
                        '}';
        }
}
