package com.ian.rest;

import com.ian.model.Employee;
import com.ian.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService service) {
        employeeService = service;
    }

    @GetMapping("/persons")
    private List<Employee> getAllPersons() {
        System.out.println("Controller");
        return employeeService.getAllEmployees();
    }

    @GetMapping("/test")
    private String test() {
        System.out.println("got");
        return "Test";
    }

    @GetMapping("/persons/{id}")
    private Employee getPerson(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/persons/{id}")
    private void deletePerson(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
    }

    @PostMapping("/persons")
    private long savePerson(@RequestBody Employee person) {
        employeeService.saveEmployee(person);
        return person.getId();
    }

    @GetMapping("/averageSalary/{division_id}")
    private long getAverageSalaryByDivision(@PathVariable("division_id") int division_id) {
        return employeeService.getAverageSalaryByDivision(division_id);
    }
}