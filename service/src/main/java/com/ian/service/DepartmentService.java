package com.ian.service;

import com.ian.dao.DepartmentDAO;
import com.ian.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    DepartmentDAO departmentDAO;

    @Autowired
    public DepartmentService(DepartmentDAO dao) {
        departmentDAO = dao;
    }

    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        departmentDAO.findAll().forEach(person -> departments.add(person));
        System.out.println("Service");
        return departments;
    }

    public Department getDepartmentById(Long id) {
        return departmentDAO.findById(id).get();
    }

    public void saveDepartment(Department department) {
        departmentDAO.save(department);
    }

    public void deleteDepartment(Long id) {
        departmentDAO.deleteById(id);
    }

}