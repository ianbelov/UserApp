package com.ian.service;

import com.ian.dao.EmployeeDAO;
import com.ian.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Employee> getAllEmployees() {
        List<Employee> persons = new ArrayList<>();
        employeeDAO.findAll().forEach(person -> persons.add(person));
        System.out.println("Service");
        return persons;
    }

    public Employee getEmployeeById(Long id) {
        return employeeDAO.findById(id).get();
    }

    public void saveEmployee(Employee person) {
        employeeDAO.save(person);
    }

    public void deleteEmployee(Long id) {
        employeeDAO.deleteById(id);
    }

    public long getAverageSalaryByDivision(int division_id) {
        long sum = 0;
        long quantity = 0;
        for (Employee e : employeeDAO.findAll()) {
            if (e.getDivisionId() == division_id) {
                sum += e.getSalary();
                quantity += 1;
            }
        }
        return sum / quantity;
    }
}