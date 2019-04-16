package com.djohannes.ac.za.factory;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import com.djohannes.ac.za.domain.Employee;

public class EmployeeFactoryTest {

    @Test
    public void getEmployee()
    {
        Employee employee = EmployeeFactory.getEmployee(121, "Nuriyat", "Johannes");
        Assert.assertEquals(121, employee.getEmpNo());
        Assert.assertEquals("Nuriyat", employee.getName());
        Assert.assertEquals("Johannes", employee.getSurname());
    }
}