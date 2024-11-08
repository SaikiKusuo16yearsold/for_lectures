package pro.sky.skyprospringdemo.service;

import pro.sky.skyprospringdemo.model.Employee;

public interface EmployeeService {


    Employee addEmployee(String fullname, Integer departmentNumber, Integer salary);


    int amountExpenses();


    int averageSalary();
}
