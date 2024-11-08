package pro.sky.skyprospringdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringdemo.model.Employee;
import pro.sky.skyprospringdemo.service.DepartmentService;
import pro.sky.skyprospringdemo.service.HelloService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "departments/min-salary")
    public Optional<Employee> minimalSalary(@RequestParam int departmentId) {
        return departmentService.findEmployeeWithMinimalSalary(departmentId);
    }

    @GetMapping(path = "departments/max-salary")
    public Optional<Employee> maximumSalary(@RequestParam int departmentId) {
        return departmentService.findEmployeeWithMaximalSalary(departmentId);
    }

    @GetMapping(path = "departments/all-by-id")
    public List<Employee> allEmployersByDepartmentNumber(@RequestParam int departmentId) {
        return departmentService.allEmployersByDepartmentNumber(departmentId);
    }

    @GetMapping(path = "departments/all")
    public Map<Integer, List<Employee>> allEmployers() {
        return departmentService.allEmployers();
    }


}
