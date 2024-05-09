package lessons.testCollection.houses_tasks.methods;

import lessons.testCollection.houses_tasks.Flat;
import lessons.testCollection.houses_tasks.House;
import lessons.testCollection.houses_tasks.HouseGenerator;

import java.util.*;

public class SimpleHouseCollectionTasks {

    // Задание 1: Вернуть количество подъездов во всех домах (List)
    public static int getTotalEntrances(List<House> houses) {
        int totalEntrances = 0;
        for (House house : houses) {
            totalEntrances += house.getEntrance();
        }
        return totalEntrances;
    }

    // Задание 2: Вернуть список всех этажей во всех домах, где имеется лифт
    // (List и Set для исключения повторений)
    public static List<Integer> getFloorsWithElevators(List<House> houses) {
        Set<Integer> uniqueFloors = new HashSet<>();

        House maxHighHouse = null;

        for (House house : houses) {

            if (maxHighHouse == null && house.isHasElevator()) {
                maxHighHouse = house;
            } else if (maxHighHouse != null && house.isHasElevator() && house.getMaxFloor() > maxHighHouse.getMaxFloor()) {
                maxHighHouse = house;
            }
        }

        for (int i = 0; i <= Objects.requireNonNull(maxHighHouse).getMaxFloor(); i++) {
            uniqueFloors.add(i);
        }

        return new ArrayList<>(uniqueFloors);
    }

    // Задание 3: Вернуть список домов, в которых более 50 квартир (List)
    public static List<House> getLargeHouses(List<House> houses) {
        List<House> largeHouses = new ArrayList<>();
        for (House house : houses) {
            if (house.getFlats().size() > 50) {
                largeHouses.add(house);
            }
        }

        return largeHouses;
    }

    // Задание 4: Проверить, есть ли хотя бы один дом без лифта (List)
    public static boolean hasHouseWithoutElevator(List<House> houses) {
        for (House house:houses){
            if(!house.isHasElevator()){
                return true;
            }
        }
        return false;
    }

    // Задание 5: Вернуть общее количество комнат во всех домах (List)
    public static int getTotalRooms(List<House> houses) {
        int totalRooms = 0;
        for (House house : houses) {
            for (Flat flat: house.getFlats()){
                totalRooms += flat.getRoomList().size();
            }
        }
        return totalRooms;
    }

    public static void main(String[] args) {
        List<House> houses = HouseGenerator.generateHouses(5); // Генерируем дома для примера

        System.out.println("Общее количество подъездов: " + getTotalEntrances(houses));
        System.out.println("Этажи с лифтами: " + getFloorsWithElevators(houses));
        System.out.println("Большие дома: " + getLargeHouses(houses));
        System.out.println("Наличие домов без лифта: " + hasHouseWithoutElevator(houses));
        System.out.println("Общее количество комнат: " + getTotalRooms(houses));
    }
}
