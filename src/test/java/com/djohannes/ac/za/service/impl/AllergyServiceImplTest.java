package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Allergy;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.AllergyRepository;
import com.djohannes.ac.za.repository.impl.AllergyRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class AllergyServiceImplTest {

    private AllergyRepository repository;
    private Allergy allergy;

    private Allergy getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = AllergyRepositoryImpl.getRepository();
        this.allergy = AllergyFactory.getAllergy("cat");
    }

    @Test
    public void aCreate()
    {
        Allergy created = this.repository.create(this.allergy);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.allergy);
    }

    @Test
    public void bRead()
    {
        Allergy saved = getSaved();
        Allergy read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void eUpdate()
    {
        String newAllergyId = "123";
        Allergy updated = new Allergy.Builder().copy(getSaved()).id(newAllergyId).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newAllergyId, updated.getId());
    }

    @Test
    public void cDelete()
    {
        Allergy saved = getSaved();
        this.repository.delete(saved.getId());
        dGetAll();
    }



    @Test
    public void dGetAll()
    {
        Set<Allergy> allergies = this.repository.getAll();
        System.out.println("In getall, all = " + allergies);
    }
}