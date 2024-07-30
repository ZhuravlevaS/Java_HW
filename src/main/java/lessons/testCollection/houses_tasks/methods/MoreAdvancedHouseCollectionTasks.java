package lessons.testCollection.houses_tasks.methods;

import lessons.testCollection.houses_tasks.*;

import java.util.*;

public class MoreAdvancedHouseCollectionTasks {

    // Задание 1: Вернуть количество домов, в которых есть квартиры площадью более 100 кв. м (List)
    public static int countHousesWithLargeFlats(List<House> houses) {
        int count = 0;
        for (House house : houses) {
            for (Flat flat : house.getFlats()) {
                if (flat.getSquare() > 100) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    // Задание 2: Вернуть список всех дверных проемов в домах, где есть лифт (List)
    public static List<Doorway> getDoorwaysInElevatorHouses(List<House> houses) {
        List<Doorway> doorways = new ArrayList<>();
        for (House house : houses) {
            if (house.isHasElevator()) {
                for (Flat flat : house.getFlats()) {
                    for (Room room : flat.getRoomList()) {
                        doorways.add(room.getDoorway());
                    }
                }
            }

        }
        return doorways;
    }

    // Задание 3: Вернуть список всех цветов коробок в домах без лифта (Set)
    public static Set<Color> getBoxColorsInNonElevatorHouses(List<House> houses) {
        Set<Color> colors = new HashSet<>();
        int colorsQuantity = Color.values().length;

        for (House house : houses) {
            if (colorsQuantity == colors.size()) break;
            if (!house.isHasElevator()) {
                for (Flat flat : house.getFlats()) {
                    if (colorsQuantity == colors.size()) break;
                    for (Room room : flat.getRoomList()) {
                        if (colorsQuantity == colors.size()) break;
                        colors.add(room.getColor());
                    }
                }
            }

        }
        return colors;
    }

    // Задание 4: Вернуть общее количество комнат на последнем этаже всех домов (List)
    public static int getTotalRoomsOnTopFloors(List<House> houses) {
        int totalRooms = 0;

        for (House house : houses) {
            for (Flat flat : house.getFlats()) {
                if (flat.getFloor() == house.getMaxFloor()) {
                    totalRooms += flat.getRoomList().size();
                }
            }
        }

        return totalRooms;
    }

    // Задание 5: Подсчитать суммарное количество комнат в квартирах, окрашенных в определенный цвет (Map)
    public static Map<Color, Integer> countRoomsByColor(List<House> houses) {
        Map<Color, Integer> roomColorCounts = new HashMap<>();

        for (House house : houses) {
            for (Flat flat : house.getFlats()) {
                for (Room room : flat.getRoomList()) {
                   roomColorCounts.put(room.getColor(), roomColorCounts.getOrDefault(room.getColor(), 0) + 1);
                }
            }
        }
        return roomColorCounts;
    }

    public static void main(String[] args) {
        List<House> houses = HouseGenerator.generateHouses(7);

        System.out.println("Дома с квартирами более 100 кв. м: " + countHousesWithLargeFlats(houses));
        System.out.println("Дверные проемы в домах с лифтом: " + getDoorwaysInElevatorHouses(houses));
        System.out.println("Цвета коробок в домах без лифта: " + getBoxColorsInNonElevatorHouses(houses));
        System.out.println("Комнаты на последних этажах: " + getTotalRoomsOnTopFloors(houses));
        System.out.println("Комнаты по цветам: " + countRoomsByColor(houses));
    }
}
