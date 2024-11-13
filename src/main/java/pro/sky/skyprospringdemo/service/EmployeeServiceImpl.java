package pro.sky.skyprospringdemo.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.model.Employee;

import java.util.*;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    public List<Employee> employees = new ArrayList<>(List.of(
            new Employee("александр", 5, 500),
            new Employee("александрa", 5, 500828),
            new Employee("александр", 5, 66600)));


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
    public Employee removeEmployee(String fullname, Integer departmentNumber, Integer salary) {
        final Employee employee = new Employee(fullname, departmentNumber, salary);
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String fullname, Integer departmentNumber, Integer salary) {
        final Employee employee = new Employee(fullname, departmentNumber, salary);
        for (Employee e : employees) {
            if (e.equals(employee)) {
                return employee;
            }
        }
        return null;
    }


    @Override
    public int amountExpenses() {
        return employees.stream().mapToInt(employee -> employee.getSalary()).sum();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
}
