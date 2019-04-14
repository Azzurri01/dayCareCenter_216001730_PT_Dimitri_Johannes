package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Student;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentFactoryTest {
    @Test
    public void getStudent() {
        Student sFactory = StudentFactory.getStudent("Naqeeb", "Johannes", 3);
        Assert.assertEquals("Naqeeb", sFactory.getsName());
        Assert.assertEquals("Johannes", sFactory.getsSurname());
        Assert.assertEquals(3, sFactory.getsAge());
    }
}