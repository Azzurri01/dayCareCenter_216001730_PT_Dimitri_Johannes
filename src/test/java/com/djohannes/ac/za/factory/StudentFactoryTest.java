package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Student1;
import org.junit.Assert;
import org.junit.Test;

public class StudentFactoryTest {
    @Test
    public void getStudent() {
        Student1 sFactory = StudentFactory1.getStudent(3);
        Assert.assertEquals(3, sFactory.getID());
    }
}