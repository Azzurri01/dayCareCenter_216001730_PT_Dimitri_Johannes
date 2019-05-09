package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Classroom;
import com.sun.xml.internal.bind.v2.ClassFactory;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClassroomFactoryTest {

    @Test
    public void getClassroom()
    {
        Classroom classroom = ClassroomFactory.getClassroom("1");
        Assert.assertNotNull(classroom.getId());
        Assert.assertEquals("1", classroom.getRoomNo());
    }
}