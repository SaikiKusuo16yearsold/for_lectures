package pro.sky.skyprospringdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringdemo.model.Employee;
import pro.sky.skyprospringdemo.service.DepartmentService;
import pro.sky.skyprospringdemo.service.DepartmentServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class DepartmentController {
    private final DepartmentService departmentServiceImp;

    public DepartmentController(DepartmentService departmentServiceImpl) {
        this.departmentServiceImp = departmentServiceImpl;
    }

    @GetMapping(path = "/department/{id}/salary/min")
    public Optional<Employee> minimalSalary(@PathVariable int id) {
        return departmentServiceImp.findEmployeeWithMinimalSalary(id);
    }

    @GetMapping(path = "department/{id}/salary/max")
    public Optional<Employee> maximumSalary(@PathVariable int id) {
        return departmentServiceImp.findEmployeeWithMaximalSalary(id);
    }

    @GetMapping(path = "department/{id}/employees")
    public List<Employee> allEmployersByDepartmentNumber(@PathVariable int id) {
        return departmentServiceImp.allEmployersByDepartmentNumber(id);
    }

    @GetMapping(path = "/department/employees")
    public Map<Integer, List<Employee>> allEmployers() {
        return departmentServiceImp.allEmployers();
    }

    @GetMapping(path = "department/{id}/salary/sum")
    public int salaryByDepartment(@PathVariable int id) {
        return departmentServiceImp.salaryByDepartmentId(id);
    }
}
