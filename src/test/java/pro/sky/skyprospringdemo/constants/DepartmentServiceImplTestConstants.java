package pro.sky.skyprospringdemo.constants;

import pro.sky.skyprospringdemo.model.Employee;

import java.util.List;

public class DepartmentServiceImplTestConstants {

    public static final List<Employee> EMPLOYEES = List.of(new Employee("Дмитрий", 24, 89),
            new Employee("Дмитрий", 25, 89));
    public static final Employee EMPLOYEE1 = new Employee("Дмитрий", 24, 89);
    public static final Employee EMPLOYEE2 = new Employee("Дмитрий", 25, 89);
    public static final Employee EMPLOYEE3 = new Employee("Иван яковлел", 52, 90);
}
