package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Employee;

public class EmployeeFactory
{
    public static Employee getEmployee(int no, String name, String surname)
    {
        return new Employee.Builder()
                .getEmpNo(no)
                .getName(name)
                .getSurname(surname)
                .build();
    }
}
