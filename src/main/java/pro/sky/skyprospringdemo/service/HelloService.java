package pro.sky.skyprospringdemo.service;

import pro.sky.skyprospringdemo.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface HelloService {


    Employee addEmployee(String fullname, Integer departmentNumber, Integer salary);


    int amountExpenses();


    int averageSalary();
}
