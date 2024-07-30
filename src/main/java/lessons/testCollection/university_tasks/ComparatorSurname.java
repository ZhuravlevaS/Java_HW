package lessons.testCollection.university_tasks;

import java.util.Comparator;

public class ComparatorSurname implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
