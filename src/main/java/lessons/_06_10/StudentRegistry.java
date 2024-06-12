package lessons._06_10;

import com.github.javafaker.Faker;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class StudentRegistry {
    @Getter
    private static final Map<Integer, StudentTest> students = new HashMap<>();
    private static final Faker FAKER = new Faker();

    public static void main(String[] args) {
        generateStudents(20);
        System.out.println(students);
    }

    public static StudentTest createStudent() {
        Major[] major = Major.values();

        return new StudentTest(
                FAKER.name().firstName(),
                FAKER.name().lastName(),
                FAKER.internet().emailAddress(),
                FAKER.number().randomDouble(2, 1, 5),
                major[FAKER.number().numberBetween(0, major.length)],
                FAKER.number().numberBetween(1, 5),
                FAKER.bool().bool()
        );
    }

    public static StudentTest createStudent(Major major, double grade, int year) {

        return new StudentTest(
                FAKER.name().firstName(),
                FAKER.name().lastName(),
                FAKER.internet().emailAddress(),
                grade,
                major,
                year,
                FAKER.bool().bool()
        );
    }

    public static void generateStudents(int count) {

        for (int i = 0; i < count; i++) {
            StudentTest studentTest = createStudent();

            students.put(studentTest.getId(), studentTest);
        }
    }

    public static void addStudent(StudentTest student) {
        if (students.containsKey(student.getId())) {
            throw new IllegalArgumentException("The student is already existed");
        }
        students.put(student.getId(), student);
    }

    public static void removeStudent(int id) throws IllegalArgumentException {
        if (!students.containsKey(id)) {
            throw new NoSuchElementException("The student is not exist");
        }
        students.remove(id);
    }

    public static List<StudentTest> findStudentsByMajor(Major major) {
        return students.values()
                .stream()
                .filter((s) -> s.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    public static double calculateAverageGrade() {
        return students.values().stream()
                .mapToDouble(StudentTest::getGrade)
                .average().orElse(0);
    }

    public static List<StudentTest> listStudentsByYear(int year) {
        return students.values().stream()
                .filter(s -> s.getYear() == year)
                .collect(Collectors.toList());
    }

    public static StudentTest getStudent(int id) {
        if (students.containsKey(id)) {
            return students.get(id);
        }
        throw new NoSuchElementException("The student is not exist");
    }

    public static int getTotalNumberOfStudents() {
        return students.size();
    }

    public static List<StudentTest> getStudentsWithGradeAbove(double grade) {
        return students.values()
                .stream().filter(s-> s.getGrade() > grade)
                .collect(Collectors.toList());
    }

    public static double getAverageGradeByMajor(Major major) {
        return students.values().stream()
                .filter((s) -> s.getMajor().equals(major))
                .mapToDouble(StudentTest::getGrade)
                .average().orElse(0);
    }

    public static boolean isStudentPresent(String email) {
        return students.values().stream()
                .anyMatch((s)-> s.getEmail().equals(email));
    }

}
