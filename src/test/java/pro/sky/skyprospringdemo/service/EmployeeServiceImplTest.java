package pro.sky.skyprospringdemo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pro.sky.skyprospringdemo.model.Employee;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.skyprospringdemo.constants.DepartmentServiceImplTestConstants.EMPLOYEE3;

public class EmployeeServiceImplTest {


    private final EmployeeService out = new EmployeeServiceImpl();

    @BeforeEach
    void setUp() {
        out.setEmployees(new ArrayList<Employee>(List.of()));
    }

    @Test
    public void addEmployeeTest() {
        Employee employee = EMPLOYEE3;
        out.addEmployee("Иван яковлел", 52, 90);
        assertTrue(out.getEmployees().get(out.getEmployees().size() - 1).equals(employee));
    }

    @Test
    public void findEmployeeTest() {
        Employee employee1 = out.findEmployee("Иван яковлел", 52, 90);
        assertNull(employee1);
        out.getEmployees().add(EMPLOYEE3);
        Employee employee2 = out.findEmployee("Иван яковлел", 52, 90);
        assertEquals(EMPLOYEE3, employee2);
    }

    @Test
    public void removeEmployeeTest() {
        Employee employee = EMPLOYEE3;
        out.getEmployees().add(employee);
        out.removeEmployee("Иван яковлел", 52, 90);
        assertEquals(0, out.getEmployees().size());

    }
}
