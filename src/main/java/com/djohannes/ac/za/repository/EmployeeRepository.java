package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Employee;

import java.util.Set;

public interface EmployeeRepository extends IRepository<Employee, String>
{
    Set<Employee> getAll();
}