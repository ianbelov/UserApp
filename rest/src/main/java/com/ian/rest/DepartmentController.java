package com.ian.rest;

import com.ian.model.Department;
import com.ian.model.Employee;
import com.ian.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService service) {
        departmentService = service;
    }

    @GetMapping("/departments")
    private List<Department> getAllPersons() {
        System.out.println("Controller");
        return departmentService.getAllDepartments();
    }

    @GetMapping("/departments/{id}")
    private Department getPerson(@PathVariable("id") Long id) {
        return departmentService.getDepartmentById(id);
    }

    @DeleteMapping("/departments/{id}")
    private void deletePerson(@PathVariable("id") Long id) {
        departmentService.deleteDepartment(id);
    }

    @PostMapping("/departments")
    private long saveDepartment(@RequestBody Department person) {
        departmentService.saveDepartment(person);
        return person.getId();
    }

}