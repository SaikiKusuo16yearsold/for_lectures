package pro.sky.skyprospringdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringdemo.model.Employee;
import pro.sky.skyprospringdemo.service.HelloService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }


    @GetMapping(path = "add/employee")
    public Employee addEmployee(@RequestParam String fullname, @RequestParam int departmentNumber,
                                @RequestParam int salary) {
        return helloService.addEmployee(fullname, departmentNumber, salary);
    }

    @GetMapping(path = "amount-expenses")
    public int amountExpenses() {
        return helloService.amountExpenses();
    }

    @GetMapping(path = "average-salary")
    public int averageSalary() {
        return helloService.averageSalary();
    }
}
