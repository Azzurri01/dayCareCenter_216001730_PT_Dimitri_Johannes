package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Classroom;
import org.junit.Assert;
import org.junit.Test;

public class ClassroomFactoryTest {

    @Test
    public void getClassroom()
    {
        Classroom classroom = ClassroomFactory.getClassroom(5);
        Assert.assertEquals(5, classroom.getRoomNo());
    }
}