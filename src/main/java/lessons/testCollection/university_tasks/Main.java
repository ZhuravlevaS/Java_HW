package lessons.testCollection.university_tasks;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static Faker faker = new Faker();
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        ComparatorSurname comparatorSurname = new ComparatorSurname();
        ComparatorName comparatorName = new ComparatorName();
        ComparatorAgeName comparatorAgeName = new ComparatorAgeName();
        ComparatorSurnameNameAge comparatorSurnameNameAge = new ComparatorSurnameNameAge();
        ComparatorGroupName comparatorGroupName = new ComparatorGroupName();
        List<Group> groupList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            studentList.add(
                    new Student(faker.name().firstName(),
                            faker.name().lastName(),
                            faker.number().numberBetween(17, 40), null)
            );
        }

        for (int i = 0; i < 5; i++) {
            groupList.add(new Group(faker.funnyName().name(), new ArrayList<>()));

            for (int j = 0; j < 10; j++) {
                Student student = new Student(faker.name().firstName(),
                        faker.name().lastName(),
                        faker.number().numberBetween(17, 40),
                        faker.idNumber().validSvSeSsn());

                groupList.get(i).addStudent(student);
            }
        }


        Collections.sort(studentList);
        System.out.println(studentList);

        studentList.sort(comparatorSurname);
        System.out.println(studentList);

        studentList.sort(comparatorName);
        System.out.println(studentList);

        studentList.sort(comparatorAgeName);
        System.out.println(studentList);

        studentList.sort(comparatorSurnameNameAge);
        System.out.println(studentList);

        groupList.sort(comparatorGroupName);
        for (Group group: groupList){
            group.sortStudents();
        }
        System.out.println(groupList);

        Person person = new Person(faker.name().firstName(),
                faker.name().lastName(),
                faker.number().numberBetween(1, 100));
        Student student1 = new Student(faker.name().firstName(),
                faker.name().lastName(),
                faker.number().numberBetween(17, 40),
                faker.idNumber().validSvSeSsn());

        System.out.println(person);
        System.out.println(student1);

        System.out.println(student1.getIdentity());

        List<Person> people = new ArrayList<>();
        List<Person> peopleUniversity = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            people.add(new Student(faker.name().firstName(),
                    faker.name().lastName(),
                    faker.number().numberBetween(17, 40),
                    faker.idNumber().validSvSeSsn()));

            people.add(new Person(faker.name().firstName(),
                    faker.name().lastName(),
                    faker.number().numberBetween(1, 100)));

            peopleUniversity.add(
                    new Student(faker.name().firstName(),
                            faker.name().lastName(),
                            faker.number().numberBetween(17, 40),
                            faker.idNumber().validSvSeSsn())
            );

            peopleUniversity.add(
                    new Teacher(faker.name().firstName(),
                            faker.name().lastName(),
                            faker.number().numberBetween(17, 40),
                            faker.animal().name())
            );
        }

        for (Person person1: people) {
            System.out.println(person1.describe());
        }

        for (Person person2: peopleUniversity) {
            System.out.println(person2.describe());

            if(person2 instanceof Student || person2 instanceof Teacher){
                System.out.println(((CommunityMember) person2).getCommunityStatus());
            }
        }



        System.out.println(student1.getIdentity());
        System.out.println(student1.getCommunityStatus());

    }

    private List<Student> getStudentsInCourse(List<Student> students, Course course) {
        List<Student> studentList = new ArrayList<>();
        for (Student student: students) {
            if (student.getCourseList().contains(course)) {
                studentList.add(student);
            }
        }

        return studentList;
    }

    private List<Course> getCoursesOfStudent(List<Course> courses, Student student) {
        List<Course> courseList = new ArrayList<>();
        for (Course course: courses) {
            if (student.getCourseList().contains(course)) {
                courseList.add(course);
            }
        }

        return courseList;
    }
}
