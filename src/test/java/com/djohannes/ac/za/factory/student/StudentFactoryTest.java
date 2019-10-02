package com.djohannes.ac.za.factory.student;

import com.djohannes.ac.za.domain.student.Student;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentFactoryTest {

    @Test
    public void getStudent()
    {
        Student stu = StudentFactory.getStudent("Dim", "Joh", "M","???", 6);
        Assert.assertEquals("Dim", stu.getFirstName());
    }
}