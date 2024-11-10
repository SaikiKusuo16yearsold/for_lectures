package pro.sky.skyprospringdemo.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

//import static pro.sky.skyprospringdemo.service.EmployeeServiceImpl.employees;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeServiceImpl) {
        this.employeeService = employeeServiceImpl;
    }


    @Override
    public List<Employee> allEmployersByDepartmentNumber(int departmentNumber) {
        return employeeService.getEmployees().stream().filter(e -> e.getDepartmentNumber() == departmentNumber).toList();
    }


    @Override
    public Map<Integer, List<Employee>> allEmployers() {
        Map<Integer, List<Employee>> allEmployers = employeeService.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentNumber));
        return allEmployers;
    }


    @Override
    public Optional<Employee> findEmployeeWithMinimalSalary(int departmentId) {
        Optional<Employee> employee = employeeService.getEmployees().stream().filter(e -> e.getDepartmentNumber() == departmentId)
                .min(Comparator.comparingInt(employ -> employ.getSalary()));
        return employee;
    }

    @Override
    public Optional<Employee> findEmployeeWithMaximalSalary(int departmentId) {
        Optional<Employee> employee = employeeService.getEmployees().stream().filter(e -> e.getDepartmentNumber() == departmentId)
                .max(Comparator.comparingInt(employ -> employ.getSalary()));
        return employee;
    }


}
