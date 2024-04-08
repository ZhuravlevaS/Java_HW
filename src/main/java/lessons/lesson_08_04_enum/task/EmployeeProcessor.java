package lessons.lesson_08_04_enum.task;

public interface EmployeeProcessor {
    void printEmployeeInfo(Employee[] employees);
    double AverageSalaryCompany(Employee[] employees);
    double AverageSalaryDepartment(Employee[] employees, Department department);
}
