package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.service.AllergyService;
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
public class AllergyServiceImplTest {

    @Autowired
    @Qualifier("AllergyServiceImpl")
    private AllergyService allergyService;
    private Allergy allergy;
    private Set<Allergy> allergies = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        allergy = AllergyFactory.getAllergy("flees");
        allergies.add(allergy);
    }

    @Test
    public void aCreate() {
        Allergy allService = allergyService.create(AllergyFactory.getAllergy("dogs"));
        System.out.println("Created allergy: " + allService.getName());
        Assert.assertNotNull(allService);
        allergies.add(allService);
    }

    @Test
    public void cUpdate() {
        String newAllergy = "cats";
        Allergy updated = allergyService.update(new Allergy.Builder().copy(allergy).name(newAllergy).build());
        System.out.println("In update, updated = " + updated);
        allergies.add(updated);
        Assert.assertEquals(updated.getId(), allergyService.read(updated.getId()));
    }

    @Test
    public void eDelete() {
        int total = allergies.size();
        System.out.println("Before deleting object: " + allergy.getId());
        allergies.remove(allergy.getId());
        System.out.println("After deleting object: " + allergy.getId());
        Assert.assertEquals(total, allergies.size() - 1);
    }

    @Test
    public void bRead()
    {
        Allergy readAllergy = allergyService.read(allergy.getId());
        System.out.println("readAllergy id: " + readAllergy.getId());
        System.out.println("allergyService id: " + allergyService.read(readAllergy.getId()));
        Assert.assertEquals(readAllergy.getId(), allergyService.read(readAllergy.getId()));
    }

    @Test
    public void dGetAll()
    {
        List<Allergy> allergyList = allergyService.getAll();
        System.out.println("Display all objects: " + allergyList.toString());
        Assert.assertEquals(allergyList.size(), allergyService.getAll().size());
    }

}