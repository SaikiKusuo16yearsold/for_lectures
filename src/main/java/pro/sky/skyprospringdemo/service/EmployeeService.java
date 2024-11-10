package pro.sky.skyprospringdemo.service;

import pro.sky.skyprospringdemo.model.Employee;

import java.util.Arrays;
import java.util.List;

public interface EmployeeService {


    Employee addEmployee(String fullname, Integer departmentNumber, Integer salary);


    int amountExpenses();


    int averageSalary();

    List<Employee> getEmployees();
}
