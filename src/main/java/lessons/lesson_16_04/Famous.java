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

        if(isFamous && checkIsFamous(famous[first], first, famous)){
            f = famous[first];
        } else {
            System.out.println("Похоже, что знаменитости нет");
        }

        return f;
    }

    private boolean checkIsFamous(Famous famous, int famousIdx, Famous[] famousArray) {
        boolean isFamous = true;
        for (int i = 0; i < famousArray.length; i++) {
            if (i != famousIdx && famous.knows(famousArray[i])){
                isFamous = false;
            }
        }

        return isFamous;
    }

    private boolean knows(Famous famous) {
        return true;
    }
}
