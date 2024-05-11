package lessons.testCollection.houses_tasks.methods;

import lessons.testCollection.houses_tasks.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComplexHouseCollectionTasks {

    // Задание 1: Вернуть список коробок, которые пролезут в дверной
    // проем по высоте во всех домах (List)
    public static List<Box> getBoxesThatFitThroughDoorways(List<House> houses) {
        List<Box> fittingBoxes = new ArrayList<>();
        Doorway minDoorHight = null;
        for (House house : houses) {
            for (Flat flat : house.getFlats()) {
                for (Room room : flat.getRoomList()) {
                    if (minDoorHight == null) {
                        minDoorHight = room.getDoorway();
                    } else if (room.getHeight() < minDoorHight.getHeight()) {
                        minDoorHight = room.getDoorway();
                    }
                }
            }
        }

        for (House house : houses) {
            for (Flat flat : house.getFlats()) {
                for (Room room : flat.getRoomList()) {
                    for (Box box : room.getBoxes()) {
                        assert minDoorHight != null;
                        if (box.getLength() < minDoorHight.getHeight() && box.getWidth() < minDoorHight.getHeight()) {
                            fittingBoxes.add(box);
                        }
                    }
                }
            }
        }

        return fittingBoxes;
    }

    // Задание 2: Вернуть количество квартир, в которых хотя бы одна комната
    // не содержит коробок (List)
    public static int countFlatsWithEmptyRooms(List<House> houses) {
        int count = 0;

        for (House house : houses) {
            for (Flat flat : house.getFlats()) {

                for (Room room: flat.getRoomList()) {
                    if (room.getBoxes().isEmpty()) {
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }

    // Задание 3: Вернуть среднюю высоту дверных проемов всех комнат во всех домах (List)
    public static double getAverageDoorwayHeight(List<House> houses) {
        double totalHeight = 0;
        int count = 0;

        for (House house: houses) {
            for (Flat flat: house.getFlats()) {
                for (Room room: flat.getRoomList()) {
                    totalHeight += room.getDoorway().getHeight();
                    count++;
                }
            }
        }

        return count > 0 ? totalHeight / count : 0;
    }

    // Задание 4: Определить, есть ли дом,
    // где каждая квартира имеет хотя
    // бы одну зеленую комнату (List)
    public static boolean isThereAHouseWithAllFlatsHavingAGreenRoom(List<House> houses) {

        for (House house: houses) {
            int flatsCount = house.getFlats().size();
            int countGreen = 0;
            for (Flat flat : house.getFlats()) {
                for (Room room : flat.getRoomList()) {
                    if(room.getColor().equals(Color.GREEN)){
                        countGreen++;
                        break;
                    }
                }
                if (flatsCount == countGreen) return true;
            }

        }

        return false;
    }

    // Задание 5: Вернуть карту, где ключи —
    // это номера этажей, а значения — списки всех коробок на этом этаже (List, Map)
    public static Map<Integer, List<Box>> getBoxesPerFloor(List<House> houses) {
        Map<Integer, List<Box>> floorToBoxes = new HashMap<>();

        for (House house : houses) {
            for (Flat flat : house.getFlats()) {
                for (Room room : flat.getRoomList()) {
                    List<Box> boxes = floorToBoxes.getOrDefault(flat.getFloor(),new ArrayList<>());
                    boxes.addAll(room.getBoxes());
                    floorToBoxes.put(flat.getFloor(), boxes);
                }
            }
        }

        return floorToBoxes;
    }

    public static void main(String[] args) {
        List<House> houses = HouseGenerator.generateHouses(777);

        System.out.println("Коробки, подходящие по высоте для дверных проемов: " + getBoxesThatFitThroughDoorways(houses).size());
        System.out.println("Квартиры с хотя бы одной пустой комнатой: " + countFlatsWithEmptyRooms(houses));
        System.out.println("Средняя высота дверных проемов: " + getAverageDoorwayHeight(houses));
        System.out.println("Дом с квартирами, в каждой из которых есть зеленая комната: " + isThereAHouseWithAllFlatsHavingAGreenRoom(houses));
        System.out.println("Коробки по этажам: " + getBoxesPerFloor(houses));
    }
}
