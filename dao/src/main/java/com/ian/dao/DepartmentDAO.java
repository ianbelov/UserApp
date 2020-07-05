package com.ian.dao;

import com.ian.model.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDAO extends CrudRepository<Department, Long> {
}
