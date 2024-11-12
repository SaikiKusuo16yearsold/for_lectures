package pro.sky.skyprospringdemo.service;

import pro.sky.skyprospringdemo.model.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {


    Employee addEmployee(String fullname, Integer departmentNumber, Integer salary);


    Employee removeEmployee(String fullname, Integer departmentNumber, Integer salary);

    Employee findEmployee(String fullname, Integer departmentNumber, Integer salary);

    int amountExpenses();


    int averageSalary();

    List<Employee> getEmployees();

    void setEmployees(ArrayList<Employee> employees);
}
