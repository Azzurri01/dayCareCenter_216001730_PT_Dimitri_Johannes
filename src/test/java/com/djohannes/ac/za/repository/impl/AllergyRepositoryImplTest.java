/*package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Allergy;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.AllergyRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AllergyRepositoryImplTest {

    private AllergyRepository repository;
    private Allergy allergy;

    private Allergy getSavedAllergy()
    {
        Set<Allergy> savedAllergy = this.repository.getAll();
        return  savedAllergy.iterator().next();
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
        Allergy createdAllergy = this.repository.create(this.allergy);
        System.out.println("Create method called: Created allergy = " + this.allergy);
        dGetAll();
        Assert.assertSame(createdAllergy, this.allergy);
    }

    @Test
    public void bRead()
    {
        Allergy savedAllergy = getSavedAllergy();
        System.out.println("Read method call 1: Reading allergyID = " + savedAllergy);
        Allergy readAllergy = this.repository.read(savedAllergy.getId());
        System.out.println("Read method call 2: Reading read = " + savedAllergy);
        dGetAll();
        Assert.assertSame(savedAllergy, readAllergy);
    }

    @Test
    public void cUpdate()
    {
        String all = "dog";
        Allergy newAllergy = new Allergy.Builder().copy(getSavedAllergy()).name(all).build();
        System.out.println("In update, about_to_updated = " +  newAllergy);
        Allergy updated = this.repository.update( newAllergy);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame( newAllergy, updated);
        dGetAll();
    }

    @Test
    public void eDelete()
    {
        Allergy savedAllergy = getSavedAllergy();
        this.repository.delete(savedAllergy.getId());
        dGetAll();
    }

    @Test
    public void dGetAll()
    {
        Set<Allergy> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}*/