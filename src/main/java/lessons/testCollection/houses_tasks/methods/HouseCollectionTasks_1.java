package lessons.testCollection.houses_tasks.methods;

import lessons.testCollection.houses_tasks.*;

import java.util.*;

public class HouseCollectionTasks_1 {

    // Задание 1: Вернуть список всех квартир во всех домах (List)
    public static List<Flat> getAllFlats(List<House> houses) {
        List<Flat> allFlats = new ArrayList<>();
        for (House house : houses) {
            allFlats.addAll(house.getFlats());
        }
        return allFlats;
    }

    // Задание 2: Вернуть множество всех уникальных цветов, используемых в комнатах квартир (Set)
    public static Set<Color> getUniqueRoomColors(List<House> houses) {
        Set<Color> colors = new HashSet<>();
        int colorsQuantity = Color.values().length;

        for (House house : houses) {
            if (colorsQuantity == colors.size()) break;
            for (Flat flat : house.getFlats()) {
                if (colorsQuantity == colors.size()) break;
                for (Room room : flat.getRoomList()) {
                    if (colorsQuantity == colors.size()) break;
                    colors.add(room.getColor());
                }
            }
        }
        return colors;
    }


    // Задание 3: Вернуть карту, ключами которой являются
    // номера этажей, а значениями - количество квартир на этом этаже (Map)
    public static Map<Integer, Integer> getFlatsCountByFloor(House house) {
        Map<Integer, Integer> floorMap = new HashMap<>();

        for (Flat flat : house.getFlats()) {
            floorMap.put(flat.getFloor(), floorMap.getOrDefault(flat.getFloor(), 0) + 1);
        }
        return floorMap;
    }

    // Задание 4: Используя очередь, вернуть список номеров квартир в порядке,
    // в котором они появляются, начиная с первого подъезда (Queue)
    public static List<Integer> getFlatNumbersInOrder(House house) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> orderedFlatNumbers = new ArrayList<>();


        return orderedFlatNumbers;
    }

    // Задание 5: Используя стек, вернуть список всех квартир
    // в обратном порядке от последнего дома к первому (Stack)
    public static List<Flat> getFlatsInReverseOrder(House house) {
        Stack<Flat> stack = new Stack<>();
        List<Flat> reversedFlats = new ArrayList<>();

        for (Flat flat : house.getFlats()) {
            stack.push(flat);
        }

        for (int i = 0; i < stack.size(); i++) {
            reversedFlats.add(stack.pop());
        }
        return reversedFlats;
    }

    public static void main(String[] args) {
        List<House> houses = HouseGenerator.generateHouses(2);

        System.out.println("Все квартиры: " + getAllFlats(houses).size());
        System.out.println("Уникальные цвета комнат: " + getUniqueRoomColors(houses).size());
        System.out.println("Квартиры по этажам: " + getFlatsCountByFloor(houses.get(0)));
        System.out.println("Номера квартир по порядку: " + getFlatNumbersInOrder(houses.get(0)));
        System.out.println("Квартиры в обратном порядке: " + getFlatsInReverseOrder(houses.get(0)));
    }
}
