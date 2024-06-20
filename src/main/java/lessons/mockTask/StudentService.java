package lessons.mockTask;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Класс StudentService
 * Описание: Этот класс содержит бизнес-логику для работы с данными студентов и курсов.
 * Поля:
 * StudentRepository studentRepository: репозиторий для управления данными.
 * Методы:
 * void registerStudent(Student student): регистрирует нового студента.
 * void enrollStudentToCourse(String studentId, String courseId): записывает студента на курс.
 * void assignGrade(String studentId, String courseId, int grade): присваивает оценку студенту по курсу.
 * Map<String, Integer> getStudentGrades(String studentId): возвращает оценки студента.
 * double calculateAverageGrade(String studentId): рассчитывает среднюю оценку студента.
 * List<Student> getStudentsWithGradesAbove(int grade): возвращает список студентов с оценками выше указанного значения.
 * List<String> getTopPerformingStudents(int n): возвращает список лучших студентов по средним оценкам.
 * void loadStudentsFromFile(String filePath) throws IOException: загружает студентов из файла.
 * void loadCoursesFromFile(String filePath) throws IOException: загружает курсы из файла.
 */
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void registerStudent(Student student)  {
        if (student == null) {
            throw new NullPointerException("Student cannot be null");
        }
        studentRepository.addStudent(student);
    }

    public void registerCourse(Course course) {
        if(course == null) {
            throw new NullPointerException("Course cannot be null");
        }
        studentRepository.addCourse(course);
    }

    public void enrollStudentToCourse(String studentId, String courseId) {
        if(studentId == null || studentId.isEmpty()) {
            throw new NullPointerException("Student id cannot be empty");
        }
        if (courseId == null || courseId.isEmpty()) {
            throw new NullPointerException("Course id cannot be empty");
        }

        studentRepository.enrollStudentToCourse(studentId, courseId);
    }

    public void assignGrade(String studentId, String courseId, int grade) {
        if(studentId == null || studentId.isEmpty()) {
            throw new NullPointerException("Student id cannot be empty");
        }
        if (courseId == null || courseId.isEmpty()) {
            throw new NullPointerException("Course id cannot be empty");
        }
        if(grade < 0) {
            throw new IllegalArgumentException("Grade cannot be less 0");
        }
        studentRepository.updateGrade(studentId, courseId, grade);
    }

    public Map<String, Integer> getStudentGrades(String studentId) {
        return studentRepository.getGradesByStudent(studentId);
    }

    public double calculateAverageGrade(String studentId) {
        return studentRepository.getAverageGrade(studentId);
    }

    public List<Student> getStudentsWithGradesAbove(int grade) {
        return studentRepository.getStudentsWithGradesAbove(grade);
    }

    public List<String> getTopPerformingStudents(int n) {
        return  studentRepository.getTopPerformingStudents(n);
    }

    public void loadStudentsFromFile(String filePath) throws IOException {
        studentRepository.loadStudentsFromFile(filePath);
    }

    public void loadCoursesFromFile(String filePath) throws IOException {
        studentRepository.loadCoursesFromFile(filePath);
    }
}