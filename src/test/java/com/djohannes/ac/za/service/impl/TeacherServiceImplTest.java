package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.service.TeacherService;
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
public class TeacherServiceImplTest {

    @Autowired
    @Qualifier("TeacherServiceImpl")
    private TeacherService teacherService;
    private Teacher teacher;
    private Set<Teacher> teachers = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        Name name = NameFactory.getName("Fowzia", "Sinclair");
        Contact contact = ContactFactory.getContact("0835133305", "fowzia.sinclair@gmail.com");
        Teacher teaService = teacherService.create(TeacherFactory.getTeacher(name, contact));
        teachers.add(teacher);
    }

    @Test
    public void aCreate() {
        Name name1 = NameFactory.getName("Fowzia", "Sinclair");
        Contact contact1 = ContactFactory.getContact("0835133305", "fowzia.sinclair@gmail.com");
        Teacher teaService = teacherService.create(TeacherFactory.getTeacher(name1, contact1));
        System.out.println("Created teacher: " + teaService.getName());
        Assert.assertNotNull(teaService);
        teachers.add(teaService);
    }

    @Test
    public void cUpdate() {
        Name name = NameFactory.getName("Fowzia", "Johannes");
        Teacher updated = teacherService.update(new Teacher.Builder().copy(teacher).name(name).build());
        System.out.println("In update, updated = " + updated);
        teachers.add(updated);
        Assert.assertEquals(updated.getId(), teacherService.read(updated.getId()));
    }

    @Test
    public void eDelete() {
        int total = teachers.size();
        System.out.println("Before deleting object: " + teacher.getId());
        teachers.remove(teacher.getId());
        System.out.println("After deleting object: " + teacher.getId());
        Assert.assertEquals(total, teachers.size() - 1);
    }

    @Test
    public void bRead()
    {
        Teacher readTeacher = teacherService.read(teacher.getId());
        System.out.println("readTeacher id: " + readTeacher.getId());
        System.out.println("teacherService id: " + teacherService.read(readTeacher.getId()));
        Assert.assertEquals(readTeacher.getId(), teacherService.read(readTeacher.getId()));
    }

    @Test
    public void dGetAll()
    {
        List<Teacher> teacherList = teacherService.getAll();
        System.out.println("Display all objects: " + teacherList.toString());
        Assert.assertEquals(teacherList.size(), teacherService.getAll().size());
    }

}