package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Teacher;
import org.junit.Assert;
import org.junit.Test;

public class TeacherFactoryTest {

    @Test
    public void getTeacher() {
        Teacher teacher = TeacherFactory.getTeacher("Bachelors");
        Assert.assertEquals("Bachelors", teacher.getQualification());
    }
}