package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.service.GradeService;
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
public class GradeServiceImplTest {

    @Autowired
    @Qualifier("GradeServiceImpl")
    private GradeService gradeService;
    private Grade grade;
    private Set<Grade> grades = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        grade = GradeFactory.getGrade("Green");
        grades.add(grade);
    }

    @Test
    public void aCreate() {
        Grade graService = gradeService.create(GradeFactory.getGrade("Brown"));
        System.out.println("Created grade: " + graService.getGrade());
        Assert.assertNotNull(graService);
        grades.add(graService);
    }

    @Test
    public void cUpdate() {
        String newGrade = "Blue";
        Grade updated = gradeService.update(new Grade.Builder().copy(grade).getGrade(newGrade).build());
        System.out.println("In update, updated = " + updated);
        grades.add(updated);
        Assert.assertEquals(updated.getId(), gradeService.read(updated.getId()));
    }

    @Test
    public void eDelete() {
        int total = grades.size();
        System.out.println("Before deleting object: " + grade.getId());
        grades.remove(grade.getId());
        System.out.println("After deleting object: " + grade.getId());
        Assert.assertEquals(total, grades.size() - 1);
    }

    @Test
    public void bRead()
    {
        Grade readGrade = gradeService.read(grade.getId());
        System.out.println("readGrade id: " + readGrade.getId());
        System.out.println("gradeService id: " + gradeService.read(readGrade.getId()));
        Assert.assertEquals(readGrade.getId(), gradeService.read(readGrade.getId()));
    }

    @Test
    public void dGetAll()
    {
        List<Grade> gradeList = gradeService.getAll();
        System.out.println("Display all objects: " + gradeList.toString());
        Assert.assertEquals(gradeList.size(), gradeService.getAll().size());
    }

}