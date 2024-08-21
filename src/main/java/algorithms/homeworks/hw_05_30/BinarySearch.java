package algorithms.homeworks.hw_05_30;

import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        List<Integer> sortedList = List.of(1, 2, 3, 4, 5, 6, 7, 7, 8, 8, 8, 8, 8, 8, 9, 10, 11);

        System.out.println(search(6, sortedList, 0, sortedList.size() - 1));
    }

    private static int search(int searchedElem, List<Integer> sortedList, int startIdx, int endIdx) {
        if (startIdx > endIdx) {
            return -1;
        }

        int middleIndex = startIdx + (endIdx - startIdx) / 2;


        if (sortedList.get(middleIndex) == searchedElem) {
            System.out.println("Index: " + middleIndex);
            return searchedElem;
        }

        if (searchedElem > sortedList.get(middleIndex)) {
            return search(searchedElem, sortedList, middleIndex + 1, endIdx);
        } else {
            return search(searchedElem, sortedList, startIdx, middleIndex - 1);
        }

    }
}
