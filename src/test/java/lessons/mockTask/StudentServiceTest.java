package lessons.mockTask;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {




    @BeforeEach
    void setUp() {
        studentService = new StudentService(studentRepository);

    }

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Mock
    Student student;

    @Mock
    Course course;

    @Test
    void registerStudentTest() {
        studentService.registerStudent(student);

        verify(studentRepository).addStudent(student);
    }

    @Test
    void registerStudentNullTest() {
        assertThrows(NullPointerException.class, () -> studentService.registerStudent(null));
    }

    @Test
    void registerCourseTest() {
        studentService.registerCourse(course);

        verify(studentRepository).addCourse(course);
    }

    @Test
    void registerCourseNullTest() {
        assertThrows(NullPointerException.class, () -> studentService.registerCourse(null));
    }

    @Test
    void enrollStudentToCourseTest() {
        studentService.enrollStudentToCourse("1", "2");

        verify(studentRepository).enrollStudentToCourse("1", "2");
    }

    @ParameterizedTest
    @CsvSource({
            "1, ",
            " , 1"
    })
    void enrollStudentToCourseNullStudentIdTest(String studentId, String courseId) {
        assertThrows(NullPointerException.class,
                () -> studentService.enrollStudentToCourse(studentId, courseId));
    }

    @ParameterizedTest
    @MethodSource("getEmptyArgsEnrollStudent")
    void enrollStudentToCourseEmptyStudentIdTest(String studentId, String courseId) {
        assertThrows(NullPointerException.class,
                () -> studentService.enrollStudentToCourse(studentId, courseId));
    }

    private static Stream<Arguments> getEmptyArgsEnrollStudent() {
        return Stream.of(
                Arguments.of("", "1"),
                Arguments.of("1", ""),
                Arguments.of("1", null),
                Arguments.of(null, "1")
        );
    }

    @Test
    void assignGrade() {
        studentService.assignGrade("1", "2", 2);

        verify(studentRepository).updateGrade("1", "2", 2);
    }
    @ParameterizedTest
    @MethodSource("getEmptyArgsAssignGrade")
    void assignGradeTrowTest(String studentId, String courseId) {
        assertThrows(NullPointerException.class,
                () -> studentService.enrollStudentToCourse(studentId, courseId));
    }

    private static Stream<Arguments> getEmptyArgsAssignGrade() {
        return Stream.of(
                Arguments.of("", "1"),
                Arguments.of("1", ""),
                Arguments.of("1", null),
                Arguments.of(null, "1")
        );
    }
}