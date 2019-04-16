package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Grade;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GradeFactoryTest {

    @Test
    public void getGrade()
    {
        Grade grade = GradeFactory.getGrade(6);
        Assert.assertEquals(1, ((Grade) grade).getGrade());
    }
}