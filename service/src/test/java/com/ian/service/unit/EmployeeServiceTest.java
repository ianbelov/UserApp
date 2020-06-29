package com.ian.service.unit;

import com.ian.dao.EmployeeDAO;
import com.ian.model.Employee;
import com.ian.service.EmployeeService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = EmployeeService.class)
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @MockBean
    private EmployeeDAO dao;

    @Autowired
    private EmployeeService service;

    private static final String NAME = "Test Test";
    private static final long ID = 111L;
    private static final long SALARY = 200L;
    private static final int DIVISION_ID = 14;
    private static final Employee employee = new Employee();

    @BeforeAll
    static void beforeAll() {
        employee.setId(ID);
        employee.setFullName(NAME);
        employee.setSalary(SALARY);
        employee.setDivisionId(DIVISION_ID);
    }

    @Test
    public void saveEmployeeTest() {
        service.saveEmployee(employee);
        verify(dao).save(employee);
    }

    @Test
    public void deleteEmployeeTest() {
        service.deleteEmployee(ID);
        verify(dao).deleteById(ID);
    }

    @Test
    public void getAllEmployeesTest() {
        when(dao.findAll()).thenReturn(new ArrayList<>());
        List<Employee> employees = service.getAllEmployees();
        verify(dao).findAll();
        assertNotNull(employees);
    }

    @Test
    public void getEmployeeByIdTest() {
        when(dao.findById(ID)).thenReturn(java.util.Optional.of(employee));
        Employee e = service.getEmployeeById(ID);
        verify(dao).findById(ID);
        assertNotNull(e);
    }

    @Test
    public void getAverageSalaryByDivision() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Test1", 250, 11));
        employees.add(new Employee("Test2", 150, 11));
        employees.add(new Employee("Test3", 150, 12));
        when(dao.findAll()).thenReturn(employees);
        assertEquals(service.getAverageSalaryByDivision(11), 200);
        verify(dao).findAll();
    }
}