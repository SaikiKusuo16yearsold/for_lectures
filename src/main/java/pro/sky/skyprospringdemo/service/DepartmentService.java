package pro.sky.skyprospringdemo.service;

import pro.sky.skyprospringdemo.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DepartmentService {
    List<Employee> allEmployersByDepartmentNumber(int departmentNumber);

    Map<Integer, List<Employee>> allEmployers();

    Optional<Employee> findEmployeeWithMinimalSalary(int departmentId);

    Optional<Employee> findEmployeeWithMaximalSalary(int departmentId);

    int salaryByDepartmentId(int departmentNumberToFilter);
}
