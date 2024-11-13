package pro.sky.skyprospringdemo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.skyprospringdemo.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static pro.sky.skyprospringdemo.constants.DepartmentServiceImplTestConstants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl out;


    @Test
    public void allEmployersByDepartmentNumberTest() {
        when(employeeService.getEmployees())
                .thenReturn(EMPLOYEES);


        assertEquals(EMPLOYEES.get(0), out.allEmployersByDepartmentNumber(24).get(0));

    }

    @Test
    public void allEmployersTest() {
        when(employeeService.getEmployees())
                .thenReturn(EMPLOYEES);


        Map<Integer, List<Employee>> answer = new HashMap<>() {{
            put(24, new ArrayList<>() {{
                add(EMPLOYEE1);
            }});
            put(25, new ArrayList<>() {{
                add(EMPLOYEE2);
            }});
        }};
        assertEquals(answer
                , out.allEmployers());
        verify(employeeService, times(1)).getEmployees();
    }

    @Test
    public void findEmployeeWithMaximalSalaryTest() {
        when(employeeService.getEmployees())
                .thenReturn(EMPLOYEES);

        assertEquals(EMPLOYEE1, out.findEmployeeWithMaximalSalary(24).get());
        verify(employeeService, times(1)).getEmployees();
    }

    @Test
    public void findEmployeeWithMinimalSalaryTest() {
        when(employeeService.getEmployees())
                .thenReturn(EMPLOYEES);

        assertEquals(EMPLOYEE1, out.findEmployeeWithMaximalSalary(24).get());
        verify(employeeService, times(1)).getEmployees();
    }

    @Test
    public void averageSalaryByDepartmentIdTest() {
        when(employeeService.getEmployees())
                .thenReturn(EMPLOYEES);

        assertEquals(89, out.salaryByDepartmentId(24));
        verify(employeeService, times(1)).getEmployees();
    }
}
