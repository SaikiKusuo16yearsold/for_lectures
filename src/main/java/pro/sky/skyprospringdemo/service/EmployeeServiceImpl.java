package pro.sky.skyprospringdemo.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.model.Employee;

import java.util.*;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private List<Employee> employees = new ArrayList<>(List.of(
            new Employee("александр", 5, 500),
            new Employee("александрa", 5, 500828),
            new Employee("александр", 5, 66600)));

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public Employee addEmployee(String fullname, Integer departmentNumber, Integer salary) {
        final Employee employee = new Employee(fullname, departmentNumber, salary);
        employees.add(employee);
        return employee;
    }

    @Override
    public int averageSalary() {
        int answer = employees.stream().mapToInt(employee -> employee.getSalary()).sum(); // Преобразуем в поток значений salary.sum();
        return (answer / employees.size());
    }

    @Override
    public int amountExpenses() {
        return employees.stream().mapToInt(employee -> employee.getSalary()).sum();
    }


}
