package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Employee;

public class EmployeeFactory
{
    public static Employee getEmployee(String id)
    {
        return new Employee.Builder()
                .getID(id)
                .build();
    }
}
