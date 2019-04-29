package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Employee;
import com.djohannes.ac.za.repository.EmployeeRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static EmployeeRepositoryImpl repository = null;
    private Set<Employee> employees;

    private EmployeeRepositoryImpl() {
        this.employees = new HashSet<>();
    }

    public static EmployeeRepository getRepository(){
        if(repository == null) repository = new EmployeeRepositoryImpl();
        return repository;
    }

    public Employee create(Employee employee){
        this.employees.add(employee);
        return employee;
    }

    public Employee read(String employeeId){
        //find the student in the set and return it if it exist
        return null;
    }

    public Employee update(Employee employee) {
        // find the student, update it and return the updated student
        return null;
    }

    public void delete(String employeeId) {
        //find the student and delete it if it exists

    }

    public Set<Employee> getAll(){
        return this.employees;
    }
}