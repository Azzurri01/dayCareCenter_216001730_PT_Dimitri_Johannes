package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Teacher;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeacherFactoryTest {

    @Test
    public void getTeacher() {
        Teacher teacher = TeacherFactory.getTeacher("Dr", "Dimitri", "Johannes",4714);
        Assert.assertEquals("Dr", teacher.gettTitle());
        Assert.assertEquals("Dimitri", teacher.gettName());
        Assert.assertEquals("Johannes", teacher.gettSurname());
        Assert.assertEquals(4714, teacher.gettEmpCode());
    }
}