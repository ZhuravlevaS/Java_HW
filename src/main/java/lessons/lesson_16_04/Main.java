package lessons.lesson_16_04;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(3);
            list.add(2);
            list.add(2);
            list.add(3);
        System.out.println(getUnique2(list));
        System.out.println(getUnique1(list));
        System.out.println(getUnique(list));
    }
    private static List<Object> getUnique(List<Integer> list) {
        Object[] i = list.toArray();
        return  Arrays.stream(i)
                .distinct()
                .toList();
    }

    private static List<Integer> getUnique1(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        return set.stream().toList();
    }
    private static List<Integer> getUnique2(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            if(newList.size() != 0 && !newList.get(newList.size() - 1).equals(list.get(i)) ){
                newList.add(list.get(i));
            } else if(i == 0){
                newList.add(list.get(i));
            }
        }
        return newList;
     }

}
