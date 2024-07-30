package lessons.testCollection.university_tasks;

import java.util.Comparator;

public class ComparatorGroupName implements Comparator<Group> {

    @Override
    public int compare(Group o1, Group o2) {
        return o1.getGroupName().compareTo(o2.getGroupName());
    }
}
