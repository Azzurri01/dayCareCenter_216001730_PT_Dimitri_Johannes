package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.SuburbRepository;
import com.djohannes.ac.za.repository.impl.SuburbRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class SuburbServiceImplTest {

    private SuburbRepository repository;
    private Suburb suburb;

    Name name = NameFactory.getName("Heideveld");
    Population population = PopulationFactory.getTotal(100000);

    private Suburb getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = SuburbRepositoryImpl.getRepository();
        this.suburb = SuburbFactory.getSuburb("7764",name, population);
    }

    @Test
    public void aCreate()
    {
        Suburb created = this.repository.create(this.suburb);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.suburb);
    }

    @Test
    public void cUpdate()
    {
        String newSuburbId = "123";
        Suburb updated = new Suburb.Builder().copy(getSaved()).id(newSuburbId).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newSuburbId, updated.getId());
    }

    @Test
    public void eDelete()
    {
        Suburb saved = getSaved();
        this.repository.delete(saved.getId());
        dGetAll();
    }

    @Test
    public void bRead()
    {
        Suburb saved = getSaved();
        Suburb read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void dGetAll()
    {
        Set<Suburb> suburbs = this.repository.getAll();
        System.out.println("In getall, all = " + suburbs);
    }
}