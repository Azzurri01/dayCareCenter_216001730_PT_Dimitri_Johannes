package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.service.CountingService;
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
public class CountingServiceImplTest {

    @Autowired
    @Qualifier("CountingServiceImpl")
    private CountingService countingService;
    private Counting counting;
    private Set<Counting> numbers = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        counting = CountingFactory.getCounting(5);
        numbers.add(counting);
    }

    @Test
    public void aCreate() {
        Counting couService = countingService.create(CountingFactory.getCounting(8));
        System.out.println("Created counting: " + couService.getNumber());
        Assert.assertNotNull(couService);
        numbers.add(couService);
    }

    @Test
    public void cUpdate() {
        int newCounting = 9;
        Counting updated = countingService.update(new Counting.Builder().copy(counting).number(newCounting).build());
        System.out.println("In update, updated = " + updated);
        numbers.add(updated);
        Assert.assertEquals(updated.getId(), countingService.read(updated.getId()));
    }

    @Test
    public void eDelete() {
        int total = numbers.size();
        System.out.println("Before deleting object: " + counting.getId());
        numbers.remove(counting.getId());
        System.out.println("After deleting object: " + counting.getId());
        Assert.assertEquals(total, numbers.size() - 1);
    }

    @Test
    public void bRead()
    {
        Counting readCounting = countingService.read(counting.getId());
        System.out.println("readCounting id: " + readCounting.getId());
        System.out.println("countingService id: " + countingService.read(readCounting.getId()));
        Assert.assertEquals(readCounting.getId(), countingService.read(readCounting.getId()));
    }

    @Test
    public void dGetAll()
    {
        List<Counting> countingList = countingService.getAll();
        System.out.println("Display all objects: " + countingList.toString());
        Assert.assertEquals(countingList.size(), countingService.getAll().size());
    }

}