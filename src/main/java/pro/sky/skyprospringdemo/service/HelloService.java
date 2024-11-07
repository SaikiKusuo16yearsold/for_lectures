package pro.sky.skyprospringdemo.service;

import pro.sky.skyprospringdemo.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface HelloService {


    Optional<Employee> findEmployeeWithMinimalSalary(int departmentNumber);


    Optional<Employee> findEmployeeWithMaximalSalary(int departmentId);

    Employee addEmployee(String fullname, Integer departmentNumber, Integer salary);


    int amountExpenses();


    List<Employee> allEmployersByDepartmentNumber(int departmentNumber);

    Map<Integer, List<Employee>> allEmployers();

    int averageSalary();
}