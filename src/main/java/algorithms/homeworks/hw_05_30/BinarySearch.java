package algorithms.homeworks.hw_05_30;

import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        List<Integer> sortedList = List.of(1, 2, 3, 4, 5, 6, 7 ,7 , 8, 8, 8, 8, 8, 8, 9, 10, 11);

        System.out.println(search(8, sortedList));
    }

    private static int search(int searchedElem, List<Integer> sortedList) {
        if(sortedList.isEmpty()) {
            return -1;
        }

        int middleIndex = sortedList.size()/2;

        if (sortedList.get(middleIndex) == searchedElem) {
            return searchedElem;
        }

        if (searchedElem > sortedList.get(middleIndex)) {
           return search(searchedElem,sortedList.subList(middleIndex + 1, sortedList.size()));
        } else {
           return search(searchedElem,sortedList.subList(0, middleIndex));
        }

    }
}
