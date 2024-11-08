package pro.sky.skyprospringdemo.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.model.Employee;

import java.util.*;

import static pro.sky.skyprospringdemo.service.EmployeeServiceImpl.employees;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();


    @Override
    public List<Employee> allEmployersByDepartmentNumber(int departmentNumber) {
        return employees.stream().filter(e -> e.getDepartmentNumber() == departmentNumber).toList();
    }


    @Override
    public Map<Integer, List<Employee>> allEmployers() {
        Map<Integer, List<Employee>> allEmployers = new HashMap<>(Map.of()) {
        };
        employees.stream().forEach(employee -> {
            if (allEmployers.get(employee.getDepartmentNumber()) == null) {
                allEmployers.put(employee.getDepartmentNumber(), new ArrayList<>(List.of(employee)));
            } else {
                allEmployers.get(employee.getDepartmentNumber()).add(employee);
            }
        });
        return allEmployers;
    }


    @Override
    public Optional<Employee> findEmployeeWithMinimalSalary(int departmentId) {
        Optional<Employee> employee = employees.stream().filter(e -> e.getDepartmentNumber() == departmentId)
                .min(Comparator.comparingInt(employ -> employ.getSalary()));
        return employee;
    }

    @Override
    public Optional<Employee> findEmployeeWithMaximalSalary(int departmentId) {
        Optional<Employee> employee = employees.stream().filter(e -> e.getDepartmentNumber() == departmentId)
                .max(Comparator.comparingInt(employ -> employ.getSalary()));
        return employee;
    }


}
