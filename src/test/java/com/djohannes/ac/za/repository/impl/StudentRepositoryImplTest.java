package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Student;
import com.djohannes.ac.za.repository.StudentRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class StudentRepositoryImplTest {

    private StudentRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = StudentRepositoryImpl.getRepository();
    }

    @Test
    public void create() {
        this.repository.create(null);
        Assert.assertEquals(null,null);
    }

    @Test
    public void read() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void getAll() {
        Set<Student> students = this.repository.getAll();
        Assert.assertEquals(1, students.size());
    }
}