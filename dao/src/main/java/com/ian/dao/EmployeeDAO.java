package com.ian.dao;

import com.ian.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDAO extends CrudRepository<Employee, Long> {
}