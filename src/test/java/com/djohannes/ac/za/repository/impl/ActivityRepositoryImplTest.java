package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Activity;
import com.djohannes.ac.za.repository.ActivityRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class ActivityRepositoryImplTest {

    private ActivityRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = ActivityRepositoryImpl.getRepository();
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
        Set<Activity> activities = this.repository.getAll();
        Assert.assertEquals(1, activities.size());
    }
}