package lessons.testCollection.houses_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HouseGenerator {
    private static final Random random = new Random();

    public static List<House> generateHouses(int numberOfHouses) {
        List<House> houses = new ArrayList<>();
        for (int i = 0; i < numberOfHouses; i++) {

            int entrance = random.nextInt(10) + 1;
            boolean hasElevator = random.nextBoolean();

            List<Flat> flats = new ArrayList<>();
            int floors = random.nextInt(99) + 1;
            int flatsPerFloor = random.nextInt(10) + 1;
            for (int floor = 0; floor < floors; floor++) {
                for (int flatIndex = 0; flatIndex < flatsPerFloor; flatIndex++) {
                    flats.add(generateFlat(floor));
                }
            }

            House house = new House(flats, entrance, hasElevator, floors);
            houses.add(house);
        }
        return houses;
    }

    private static Flat generateFlat(int floor) {
        int roomsCount = random.nextInt(5) + 1;
        List<Room> rooms = new ArrayList<>();
        double totalSquare = 0;

        for (int i = 0; i < roomsCount; i++) {

            double length = random.nextDouble() * 10 + 1;
            double width = random.nextDouble() * 10 + 1;
            double height = random.nextDouble() * 3 + 2;
             Color color = Color.values()[random.nextInt(Color.values().length)];
            double doorwayLength = Math.min(length, width) - 0.5;
            double doorwayHeight = height - 0.5;

            Doorway doorway = new Doorway(doorwayLength, doorwayHeight);
            Room room = new Room(length, width, height, doorway, null, color);

            double roomVolume = room.getLength() * room.getWidth() * room.getHeight();
            List<Box> boxes = generateBoxes(roomVolume);
            room.setBoxes(boxes);
            totalSquare += room.getLength() * room.getWidth();
            rooms.add(room);
        }

        return new Flat(rooms,totalSquare, random.nextInt(1000), floor);
    }

    private static List<Box> generateBoxes(double roomVolume) {
        List<Box> boxes = new ArrayList<>();
        double remainingVolume = roomVolume;
        while (remainingVolume > 0) {

            double length = random.nextDouble() * 2 + 0.5;
            double width = random.nextDouble() * 2 + 0.5;
            double height = random.nextDouble() * 2 + 0.5;
            double weight = random.nextDouble() * 10;
            Color color = Color.values()[random.nextInt(Color.values().length)];
            double boxVolume = length * width * height;

            Box box = new Box(length, width, height, weight, color);

            if (boxVolume <= remainingVolume) {
                boxes.add(box);
                remainingVolume -= boxVolume;
            } else {
                break;
            }
        }
        return boxes;
    }

    public static void main(String[] args) {
        List<House> houses = generateHouses(777);
        System.out.println(houses.get(0).isHasElevator());
    }
}