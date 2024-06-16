package lessons.testCollection.university_tasks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor
public class Group {
    private String groupName;
    private List<Student> studentList;

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void sortStudents(){
        ComparatorAge comparatorAge = new ComparatorAge();
        if(studentList != null && !studentList.isEmpty()){
            studentList.sort(comparatorAge);
        }
    }
}
