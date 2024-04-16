package lessons.lesson_16_04;
public class Famous {
    Famous getFamous(Famous[] famous) {
        Famous f = null;
        int first = 0;
        int last = famous.length - 1;

        while (first != last) {
            if(famous[first].knows(famous[last])) {
                first++;
            } else {
                last--;
            }
        }

        boolean isFamous = true;

        for(int i = 0; i < famous.length; i++) {
            if(i != first && !famous[i].knows(famous[first])) {
                isFamous = false;
            }
        }

        if(isFamous){
            f = famous[first];
        } else {
            System.out.println("Похоже, что знаменитости нет");
        }

        return f;
    }

    private boolean knows(Famous famous) {
        return true;
    }
}
