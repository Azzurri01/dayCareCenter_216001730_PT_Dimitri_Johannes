package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.ProvinceRepository;
import com.djohannes.ac.za.repository.impl.ProvinceRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class ProvinceServiceImplTest {

    private ProvinceRepository repository;
    private Province province;

    Name name = NameFactory.schoolName("Western Province");
    Population population = PopulationFactory.getTotal(10000000);

    private Province getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = ProvinceRepositoryImpl.getRepository();
        this.province = ProvinceFactory.getProvince(name, population);
    }

    @Test
    public void aCreate()
    {
        Province created = this.repository.create(this.province);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.province);
    }

    @Test
    public void bUpdate()
    {
        String newProvinceId = "123";
        Province updated = new Province.Builder().copy(getSaved()).id(newProvinceId).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newProvinceId, updated.getId());
    }

    @Test
    public void cDelete()
    {
        Province saved = getSaved();
        this.repository.delete(saved.getId());
        eGetAll();
    }

    @Test
    public void dRead()
    {
        Province saved = getSaved();
        Province read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void eGetAll()
    {
        Set<Province> provinces = this.repository.getAll();
        System.out.println("In getall, all = " + provinces);
    }
}