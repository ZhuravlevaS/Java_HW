package lessons._06_10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

class StudentRegistryTest {
    StudentTest student1 = StudentRegistry.createStudent(Major.DEVELOPER, 5, 4);
    StudentTest student2 = StudentRegistry.createStudent(Major.DEVELOPER, 4, 5);
    StudentTest student3 = StudentRegistry.createStudent(Major.TEACHER, 3, 1);
    @BeforeEach
    void setUp() {
        StudentRegistry.getStudents().clear();
    }

    @Test
    void generateStudentsTest() {
        StudentRegistry.generateStudents(10);
        Assertions.assertEquals(10, StudentRegistry.getStudents().size());
    }

    @Test
    void addStudentTest() {
        StudentTest student = StudentRegistry.createStudent();
        StudentRegistry.addStudent(student);
        Assertions.assertTrue(StudentRegistry.getStudents().containsKey(student.getId()));
    }

    @Test
    void addStudentExceptionTest() {
        StudentTest student = StudentRegistry.createStudent();
        StudentRegistry.addStudent(student);
        Throwable t = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> StudentRegistry.addStudent(student));

        Assertions.assertEquals("The student is already existed", t.getMessage());
    }

    @Test
    void removeStudentTest() {
        StudentRegistry.addStudent(student1);
        StudentRegistry.removeStudent(student1.getId());

        Assertions.assertFalse(StudentRegistry.getStudents().containsKey(student1.getId()));

    }

    @Test
    void removeStudentExceptionTest() {
        Throwable t = Assertions.assertThrows(
                NoSuchElementException.class,
                () -> StudentRegistry.removeStudent(-1));

        Assertions.assertEquals("The student is not exist", t.getMessage());
    }

    @Test
    void findStudentsByMajorTest() {
        StudentRegistry.addStudent(student1);
        StudentRegistry.addStudent(student2);
        StudentRegistry.addStudent(student3);

        List<StudentTest> list = StudentRegistry.findStudentsByMajor(Major.DEVELOPER);

        Assertions.assertEquals(2, list.size());
    }

    @Test
    void calculateAverageGradeTest() {
        StudentRegistry.addStudent(student1);
        StudentRegistry.addStudent(student2);

        Assertions.assertEquals(4.5, StudentRegistry.calculateAverageGrade());
    }

    @Test
    void calculateAverageGradeZeroTest() {
        Assertions.assertEquals(0, StudentRegistry.calculateAverageGrade());
    }

    @Test
    void listStudentsByYearTest() {
        StudentRegistry.addStudent(student1);
        StudentRegistry.addStudent(student2);
        StudentRegistry.addStudent(student3);

        Assertions.assertEquals(1, StudentRegistry.listStudentsByYear(1).size());
    }

    @Test
    void getStudentTest() {
        StudentRegistry.addStudent(student1);

        StudentTest st = StudentRegistry.getStudent(student1.getId());
        Assertions.assertEquals(student1.getId(), st.getId());
    }

    @Test
    void getStudentExceptionTest() {
        Assertions.assertThrows(NoSuchElementException.class, ()-> StudentRegistry.getStudent(student1.getId()));
    }

    @Test
    void getTotalNumberOfStudents() {
        StudentRegistry.generateStudents(10);

        Assertions.assertEquals(10, StudentRegistry.getTotalNumberOfStudents());

    }

    @Test
    void getStudentsWithGradeAbove() {
        StudentRegistry.addStudent(student1);
        StudentRegistry.addStudent(student2);
        StudentRegistry.addStudent(student3);

        Assertions.assertEquals(1, StudentRegistry.getStudentsWithGradeAbove(4).size());
    }

    @Test
    void isStudentPresentPositiveTest() {
        StudentRegistry.addStudent(student1);

        Assertions.assertTrue(StudentRegistry.isStudentPresent(student1.getEmail()));
    }

    @Test
    void isStudentPresentNegativeTest() {
        StudentRegistry.addStudent(student2);
        StudentRegistry.addStudent(student3);

        Assertions.assertFalse(StudentRegistry.isStudentPresent(student1.getEmail()));
    }

    @Test
    void getAverageGradeByMajor() {
        StudentRegistry.addStudent(student2);
        StudentRegistry.addStudent(student3);
        StudentRegistry.addStudent(student1);

        Assertions.assertEquals(4.5, StudentRegistry.getAverageGradeByMajor(Major.DEVELOPER));
    }
}