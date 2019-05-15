package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.ParentRepository;
import com.djohannes.ac.za.repository.impl.ParentRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class ParentServiceImplTest {

    private ParentRepository repository;
    private Parent parent;

    Name name = NameFactory.getName("Dimitri", "Johannes");
    Contact contact = ContactFactory.getContact("0824512653", "dimitri.johannes@gmail.com");

    private Parent getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = ParentRepositoryImpl.getRepository();
        this.parent = ParentFactory.getParent(name, contact);
    }

    @Test
    public void aCreate()
    {
        Parent created = this.repository.create(this.parent);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.parent);
    }

    @Test
    public void cUpdate()
    {
        String newParentId = "123";
        Parent updated = new Parent.Builder().copy(getSaved()).id(newParentId).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newParentId, updated.getId());
    }

    @Test
    public void eDelete()
    {
        Parent saved = getSaved();
        this.repository.delete(saved.getId());
        dGetAll();
    }

    @Test
    public void bRead()
    {
        Parent saved = getSaved();
        Parent read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void dGetAll()
    {
        Set<Parent> parents = this.repository.getAll();
        System.out.println("In getall, all = " + parents);
    }
}