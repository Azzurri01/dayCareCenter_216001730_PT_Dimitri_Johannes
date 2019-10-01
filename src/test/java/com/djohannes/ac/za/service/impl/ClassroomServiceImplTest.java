package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.service.ClassroomService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClassroomServiceImplTest {

    @Autowired
    @Qualifier("ClassroomServiceImpl")
    private ClassroomService classroomService;
    private Classroom classroom;
    private Set<Classroom> classrooms = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        classroom = ClassroomFactory.getClassroom("Green");
        classrooms.add(classroom);
    }

    @Test
    public void aCreate() {
        Classroom claService = classroomService.create(ClassroomFactory.getClassroom("Brown"));
        System.out.println("Created classroom: " + claService.getRoomNo());
        Assert.assertNotNull(claService);
        classrooms.add(claService);
    }

    @Test
    public void cUpdate() {
        String newClassroom = "Blue";
        Classroom updated = classroomService.update(new Classroom.Builder().copy(classroom).room(newClassroom).build());
        System.out.println("In update, updated = " + updated);
        classrooms.add(updated);
        Assert.assertEquals(updated.getId(), classroomService.read(updated.getId()));
    }

    @Test
    public void eDelete() {
        int total = classrooms.size();
        System.out.println("Before deleting object: " + classroom.getId());
        classrooms.remove(classroom.getId());
        System.out.println("After deleting object: " + classroom.getId());
        Assert.assertEquals(total, classrooms.size() - 1);
    }

    @Test
    public void bRead()
    {
        Classroom readClassroom = classroomService.read(classroom.getId());
        System.out.println("readClassroom id: " + readClassroom.getId());
        System.out.println("classroomService id: " + classroomService.read(readClassroom.getId()));
        Assert.assertEquals(readClassroom.getId(), classroomService.read(readClassroom.getId()));
    }

    @Test
    public void dGetAll()
    {
        List<Classroom> classroomList = classroomService.getAll();
        System.out.println("Display all objects: " + classroomList.toString());
        Assert.assertEquals(classroomList.size(), classroomService.getAll().size());
    }

}