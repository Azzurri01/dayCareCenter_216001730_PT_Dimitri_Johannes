package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Student;
import org.junit.Assert;
import org.junit.Test;

public class StudentFactoryTest {
    @Test
    public void getStudent() {
        Student sFactory = StudentFactory.getStudent("Naqeeb", "Johannes", 3);
        Assert.assertEquals("Naqeeb", sFactory.getStudentFirstName());
        Assert.assertEquals("Johannes", sFactory.getStudentLastName());
        Assert.assertEquals(3, sFactory.getAge());
    }
}