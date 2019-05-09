package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.NameRepository;
import com.djohannes.ac.za.repository.impl.NameRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class NameServiceImplTest {

    private NameRepository repository;
    private Name name;


    private Name getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = NameRepositoryImpl.getRepository();
        this.name = NameFactory.getName("Nuriyat", "Johannes");
    }

    @Test
    public void aCreate()
    {
        Name created = this.repository.create(this.name);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.name);
    }

    @Test
    public void bUpdate()
    {
        String newNameId = "123";
        Name updated = new Name.Builder().copy(getSaved()).id(newNameId).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newNameId, updated.getId());
    }

    @Test
    public void cDelete()
    {
        Name saved = getSaved();
        this.repository.delete(saved.getId());
        eGetAll();
    }

    @Test
    public void dRead()
    {
        Name saved = getSaved();
        Name read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void eGetAll()
    {
        Set<Name> names = this.repository.getAll();
        System.out.println("In getall, all = " + names);
    }
}