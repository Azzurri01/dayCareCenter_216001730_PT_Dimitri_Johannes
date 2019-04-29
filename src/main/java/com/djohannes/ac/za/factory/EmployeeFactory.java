package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Employee;

public class EmployeeFactory
{
<<<<<<< HEAD
    public static Employee getEmployee(String id)
=======
    public static Employee getEmployee(int id)
>>>>>>> f36dbde0fbcd5e4d49bd3de4e3a5dd476a0f17cc
    {
        return new Employee.Builder()
                .getID(id)
                .build();
    }
}
