package lessons.testCollection.houses_tasks.methods;

import lessons.testCollection.houses_tasks.*;

import java.util.*;

public class DetailedHouseCollectionTasks {

    // Задание 1: Вернуть список всех коробок,
    // вес которых больше среднего веса всех коробок (List)
    public static List<Box> getBoxesHeavierThanAverage(List<House> houses) {
        int boxesQuantity = 0;
        double commonWeihght = 0;
        List<Box> allBoxes = new ArrayList<>();
        List<Box> heavyBoxes = new ArrayList<>();

        for (House house: houses){
            for (Flat flat: house.getFlats()){
                for (Room room: flat.getRoomList()){
                    allBoxes.addAll(room.getBoxes());
                    boxesQuantity += room.getBoxes().size();
                    for (Box box: room.getBoxes()) {
                        commonWeihght += box.getWeight();
                    }
                }
            }
        }

        double averageWeight = commonWeihght/boxesQuantity;

        for (Box box: allBoxes){
            if (box.getWeight() > averageWeight){
                heavyBoxes.add(box);
            }
        }
        return heavyBoxes;
    }

    // Задание 2: Вернуть карту, где ключи — это цвета коробок,
    // а значения — количество комнат,
    // содержащих хотя бы одну коробку такого цвета (List, Map)
    public static Map<Color, Integer> getRoomCountByBoxColor(List<House> houses) {
        Map<Color, Integer> roomCountByColor = new HashMap<>();

        for (House house: houses){
            for (Flat flat: house.getFlats()){
                for (Room room: flat.getRoomList()){
                    Set<Color> uniqueColors = new HashSet<>();
                    int colorsQuantity = Color.values().length;
                    for (Box box: room.getBoxes()) {
                        Color color = box.getColor();
                        if(!uniqueColors.contains(color)){
                            uniqueColors.add(color);
                            roomCountByColor.put(color,roomCountByColor.getOrDefault(color, 0) + 1 );
                        }
                        if (uniqueColors.size() == colorsQuantity){
                            break;
                        }
                    }
                }
            }
        }

        return roomCountByColor;
    }

    // Задание 3: Найти средний вес коробок в комнатах с зелеными стенами (List)
    public static double getAverageWeightOfBoxesInGreenRooms(List<House> houses) {
        double totalWeight = 0;
        int boxCount = 0;

        for (House house: houses){
            for (Flat flat: house.getFlats()){
                for (Room room: flat.getRoomList()){
                    if(room.getColor().equals(Color.GREEN)) {
                        boxCount += room.getBoxes().size();
                        for (Box box: room.getBoxes()) {
                            totalWeight += box.getWeight();
                        }
                    }

                }
            }
        }

        return boxCount > 0 ? totalWeight / boxCount : 0;
    }

    // Задание 4: Определить, в каком доме самый
    // большой процент квартир с коробками (List)
    public static House getHouseWithHighestPercentageOfFlatsWithBoxes(List<House> houses) {
        House houseWithHighestPercentage = null;
        double percentageMax = 0;
        for (House house: houses) {
            if (houseWithHighestPercentage != null){
                houseWithHighestPercentage = house;
                percentageMax = getPercentage(house);
            } else {
                if (getPercentage(house) > percentageMax){
                    houseWithHighestPercentage = house;
                    percentageMax = getPercentage(house);
                }
            }
        }

        return houseWithHighestPercentage;
    }

    public static double getPercentage(House house) {
        int flatWithBoxes = 0;
        int countFlats = 0;
        for (Flat flat: house.getFlats()){

            for (Room room: flat.getRoomList()){
                countFlats += flat.getRoomList().size();
                if (!room.getBoxes().isEmpty()){
                    flatWithBoxes++;
                    break;
                }
            }
        }

        return (double) flatWithBoxes /countFlats * 100;
    }

    // Задание 5: Подсчитать количество квартир,
    // которые находятся в домах без лифтов и содержат коробки (List)
    public static int countFlatsWithBoxesInHousesWithoutElevators(List<House> houses) {
        int count = 0;
        for (House house: houses) {
            if (!house.isHasElevator()){
                for (Flat flat: house.getFlats()){
                   for (Room room: flat.getRoomList()){
                       if (!flat.getRoomList().get(0).getBoxes().isEmpty()){
                           count++;
                       }
                   }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<House> houses = HouseGenerator.generateHouses(7);

        System.out.println("Коробки тяжелее среднего: " + getBoxesHeavierThanAverage(houses).size());
        System.out.println("Количество комнат по цветам коробок: " + getRoomCountByBoxColor(houses));
        System.out.println("Средний вес коробок в зеленых комнатах: " + getAverageWeightOfBoxesInGreenRooms(houses));
        System.out.println("Дом с самым большим процентом квартир с коробками: " + getHouseWithHighestPercentageOfFlatsWithBoxes(houses));
        System.out.println("Квартиры с коробками в домах без лифтов: " + countFlatsWithBoxesInHousesWithoutElevators(houses));
    }
}