package com.ian.app;

import com.ian.dao.EmployeeDAO;
import com.ian.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements ApplicationRunner {

    EmployeeDAO employeeDAO;

    @Autowired
    public DataInit(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void run(ApplicationArguments args) {
        Employee e1 = new Employee();
        e1.setFullName("Ivan Belov");
        e1.setSalary(400);
        e1.setDivisionId(12);

        Employee e2 = new Employee();
        e2.setFullName("Alex Lukashevich");
        e2.setSalary(700);
        e2.setDivisionId(12);

        Employee e3 = new Employee();
        e3.setFullName("Nikolay Borzenkov");
        e3.setSalary(500);
        e3.setDivisionId(11);

        Employee e4 = new Employee();
        e4.setFullName("Nikita Zakharchenko");
        e4.setSalary(900);
        e4.setDivisionId(11);

        employeeDAO.save(e1);
        employeeDAO.save(e2);
        employeeDAO.save(e3);
        employeeDAO.save(e4);
    }
}