package lessons.lesson_27_03.task1;

public class Task1 {
    public static void main(String[] args) {
        Auto auto = new Auto("audi", 100, "good");
        Bicycle meBike = new Bicycle("myBike",20, "cool");
        Vehicle smth = new Vehicle("Smth", 0);

        Vehicle[] array =  {meBike, auto, smth};

        for (Vehicle vehicle : array) {
            System.out.println(vehicle.toString());
        }
    }
}
