package lessons.testCollection.university_tasks;

import java.util.Comparator;

public class ComparatorSurnameNameAge implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        int result = o1.getSurname().compareTo(o2.getSurname());
        if (result == 0){
            result = o1.getName().compareTo(o2.getName());
        }

        if (result == 0) {
            result = o1.getAge() - o2.getAge();
        }

        return result;
    }
}
