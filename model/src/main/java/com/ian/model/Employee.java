package com.ian.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private long id;
    private String full_name;
    private long salary;
    private int division_id;

    public Employee() {
    }

    public Employee(String full_name, long salary, int division_id) {
        this.full_name = full_name;
        this.salary = salary;
        this.division_id = division_id;
    }

    public Employee(long id, String full_name, long salary, int division_id) {
        this.id = id;
        this.full_name = full_name;
        this.salary = salary;
        this.division_id = division_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return full_name;
    }

    public void setFullName(String full_name) {
        this.full_name = full_name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public int getDivisionId() {
        return division_id;
    }

    public void setDivisionId(int division_id) {
        this.division_id = division_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, full_name, salary, division_id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() &&
                getSalary() == employee.getSalary() &&
                getDivisionId() == employee.getDivisionId() &&
                Objects.equals(full_name, employee.full_name);
    }

}