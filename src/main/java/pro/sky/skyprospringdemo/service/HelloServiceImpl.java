package pro.sky.skyprospringdemo.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.model.Employee;

import java.util.*;


@Service
public class HelloServiceImpl implements HelloService {

    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("александр", 5, 500),
            new Employee("александрa", 5, 500828),
            new Employee("александр", 5, 66600)));


    @Override
    public Optional<Employee> findEmployeeWithMaximalSalary(int departmentId) {
        Optional<Employee> employee = employees.stream().filter(e -> e.getDepartmentNumber() == departmentId)
                .max(Comparator.comparingInt(employ -> employ.getSalary()));
        return employee;
    }

    @Override
    public Optional<Employee> findEmployeeWithMinimalSalary(int departmentId) {
        Optional<Employee> employee = employees.stream().filter(e -> e.getDepartmentNumber() == departmentId)
                .min(Comparator.comparingInt(employ -> employ.getSalary()));
        return employee;
    }

    @Override
    public ResponseEntity<Object> addEmployee(String fullname, Integer departmentNumber, Integer salary) {
        if (StringUtils.isAlphaSpace(fullname)) {
            fullname = StringUtils.stripToEmpty(fullname);
            String answer = "";
            for (String s : StringUtils.split(fullname)) {
                s = StringUtils.capitalize(s);
                answer = answer + s + " ";
            }
            fullname = StringUtils.stripToEmpty(answer);

            final Employee employee = new Employee(fullname, departmentNumber, salary);
            employees.add(employee);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return null;
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


}
