package com.ian.service;

import com.ian.dao.EmployeeDAO;
import com.ian.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    EmployeeDAO employeeDAO;

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:tcp://localhost/~/test";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";


    @Autowired
    public EmployeeService(EmployeeDAO dao) {
        employeeDAO = dao;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> persons = new ArrayList<>();
        employeeDAO.findAll().forEach(persons::add);
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
        try {
            Connection conn;
            Statement stmt;

            //Register JDBC driver
            Class.forName(DB_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);

            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT AVG(SALARY) FROM EMPLOYEE WHERE DEPARTMENT_ID =" + division_id;
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            long result = rs.getLong("AVG(SALARY)");

            //Close resources
            stmt.close();
            conn.close();

            return result;
        } catch (Exception se) {
            se.printStackTrace();
        }

        return 404L;
    }
}