package lessons.testCollection.houses_tasks.methods;

import errors.ErrorsMessages;
import exceptions.DivideZeroException;
import lessons.testCollection.houses_tasks.Flat;
import lessons.testCollection.houses_tasks.House;
import lessons.testCollection.houses_tasks.HouseGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdvancedHouseCollectionTasks {

    // Задание 1: Вернуть список номеров квартир, у которых
    // количество комнат больше среднего кол-ва комнат по всем квартирам каждого дома (List)
    public static List<Integer> getFlatsWithMoreRoomsThanAverage(List<House> houses) throws DivideZeroException {
        List<Integer> flatNumbers = new ArrayList<>();
        int totalRoom = 0;
        int count = 0;
        double averageRoom = 0;

        for (House house : houses) {
            for (Flat flat : house.getFlats()) {
                totalRoom += flat.getRoomList().size();
                count++;
            }
        }

        if(count == 0){
            throw new DivideZeroException(ErrorsMessages.DIVIDER_CANNOT_BE_ZERO);
        }

        averageRoom = (double) totalRoom /count;

        for (House house : houses) {
            for (Flat flat : house.getFlats()) {
                if (flat.getRoomList().size() > averageRoom){
                    flatNumbers.add(flat.getFlatnumber());
                }
            }
        }

        return flatNumbers;
    }

    // Задание 2: Вернуть список этажей, на которых есть лифт
    // (List и Set для исключения повторений)
    public static List<Integer> getFloorsWithElevator(List<House> houses) {
        Set<Integer> floorsWithElevator = new HashSet<>();

        // Проходим по списку домов и добавляем номера этажей с лифтом в набор
        for (House house : houses) {
            if (house.isHasElevator()) {
                floorsWithElevator.addAll(getFloorNumbers(house));
            }

        }

        return new ArrayList<>(floorsWithElevator);
    }

    private static Set<Integer> getFloorNumbers(House house) {
        Set<Integer> floors = new HashSet<>();
        for (Flat flat : house.getFlats()) {
            floors.add(flat.getFloor());
        }
        return floors;
    }

    // Задание 3: Подсчитать общее количество подъездов в домах, которые имеют больше 100 квартир (List)
    public static int getTotalEntrancesInLargeHouses(List<House> houses) {
        int totalEntrances = 0;
        for (House house : houses) {
            if (house.getFlats().size() > 100) {
                totalEntrances += house.getEntrance();
            }
        }
        return totalEntrances;
    }

    // Задание 4: Определить, все ли дома имеют лифт (List)
    public static boolean areAllHousesWithElevator(List<House> houses) {
        for (House house : houses) {
            if (!house.isHasElevator()){
                return false;
            }
        }
        return true;
    }

    // Задание 5: Подсчитать общее количество квартир, расположенных на первом этаже (List)
    public static int getTotalFirstFloorFlats(List<House> houses) {
        int count = 0;
        for (House house : houses) {
            for (Flat flat : house.getFlats()) {
                if(flat.getFloor() == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<House> houses = HouseGenerator.generateHouses(3); // Генерируем дома для примера

        System.out.println(getFlatsWithMoreRoomsThanAverage(houses));
        System.out.println(getFloorsWithElevator(houses));
        System.out.println(getTotalEntrancesInLargeHouses(houses));
        System.out.println(areAllHousesWithElevator(houses));
        System.out.println(getTotalFirstFloorFlats(houses));
    }
}