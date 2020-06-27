package com.ian.service;

import com.ian.dao.EmployeeDAO;
import com.ian.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(EmployeeDAO dao) {
        employeeDAO = dao;
    }

    public List<Employee> getAllPersons() {
        List<Employee> persons = new ArrayList<>();
        employeeDAO.findAll().forEach(person -> persons.add(person));
        System.out.println("Service");
        return persons;
    }

    public Employee getPersonById(Long id) {
        return employeeDAO.findById(id).get();
    }

    public void saveOrUpdate(Employee person) {
        employeeDAO.save(person);
    }

    public void delete(Long id) {
        employeeDAO.deleteById(id);
    }
}