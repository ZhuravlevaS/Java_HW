package lessons.lesson_08_04_enum.task;

public class EmployeeAnalytics implements EmployeeProcessor {
    @Override
    public void printEmployeeInfo(Employee[] employees) {
        for (Employee employee: employees) {
            System.out.println(employee.toString());
        }
    }

    @Override
    public double AverageSalaryCompany(Employee[] employees) {
        double salaries = 0;
        for (Employee employee: employees) {
            salaries = salaries + employee.getSalary();
        }

        return  salaries/employees.length;
    }

    @Override
    public double AverageSalaryDepartment(Employee[] employees, Department department) {
        double salaries = 0;
        int countEmployee = 0;
        for (Employee employee: employees) {
            if(department.equals(employee.getDepartment())){
                salaries = salaries + employee.getSalary();
                countEmployee++;
            }
        }

        return  salaries/countEmployee;
    }

    public static void main(String[] args) {
        EmployeeAnalytics analytics = new EmployeeAnalytics();
        Employee[] employees = Company.employees;
        analytics.printEmployeeInfo(employees);
        System.out.println(analytics.AverageSalaryCompany(employees));
        System.out.println(analytics.AverageSalaryDepartment(employees,Department.DEVELOPMENT));
    }
}
