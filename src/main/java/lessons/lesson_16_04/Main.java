package lessons.lesson_16_04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(3);
            list.add(2);
            list.add(2);
            list.add(3);
        System.out.println(getUnique2(list));
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
