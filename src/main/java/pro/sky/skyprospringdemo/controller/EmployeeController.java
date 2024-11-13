package pro.sky.skyprospringdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringdemo.model.Employee;
import pro.sky.skyprospringdemo.service.EmployeeService;
import pro.sky.skyprospringdemo.service.EmployeeServiceImpl;


@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "add/employee")
    public Employee addEmployee(@RequestParam String fullname, @RequestParam int departmentNumber,
                                @RequestParam int salary) {
        return employeeService.addEmployee(fullname, departmentNumber, salary);
    }

    @GetMapping(path = "amount-expenses")
    public int amountExpenses() {
        return employeeService.amountExpenses();
    }

    @GetMapping(path = "average-salary")
    public int averageSalary() {
        return employeeService.averageSalary();
    }

    @GetMapping(path = "remove-employee")
    public Employee removeEmployee(@RequestParam String fullname, @RequestParam int departmentId, @RequestParam int salary) {
        return employeeService.removeEmployee(fullname, departmentId, salary);
    }

    @GetMapping(path = "find-employee")
    public Employee findEmployee(@RequestParam String fullname, @RequestParam int departmentId, @RequestParam int salary) {
        return employeeService.findEmployee(fullname, departmentId, salary);
    }


}
