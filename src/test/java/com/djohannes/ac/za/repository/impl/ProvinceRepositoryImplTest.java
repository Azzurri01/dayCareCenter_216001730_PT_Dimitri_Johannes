package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.Population;
import com.djohannes.ac.za.domain.Province;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.ProvinceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProvinceRepositoryImplTest {

    private ProvinceRepository repository;
    private Province province;

    Name name = NameFactory.schoolName("Western Province");
    Population population = PopulationFactory.getTotal(10000000);

    private Province getSavedProvince()
    {
        Set<Province> savedProvince = this.repository.getAll();
        return  savedProvince.iterator().next();
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
        Province createdProvince = this.repository.create(this.province);
        System.out.println("Create method called: Created province = " + this.province);
        eGetAll();
        Assert.assertSame(createdProvince, this.province);
    }

    @Test
    public void bRead()
    {
        Province savedProvince = getSavedProvince();
        System.out.println("Read method call 1: Reading provinceID = " + savedProvince.getId());
        Province readProvince = this.repository.read(savedProvince.getId());
        System.out.println("Read method call 2: Reading read = " + savedProvince.getId());
        eGetAll();
        Assert.assertSame(savedProvince, readProvince);
    }

    @Test
    public void cUpdate()
    {
        String newId = "112";
        Province streetNo = new Province.Builder().copy(getSavedProvince()).id(newId).build();
        System.out.println("In update, about_to_updated = " + province);
        Province updated = this.repository.update(province);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newId, updated.getId().toString());;
        eGetAll();
    }

    @Test
    public void dDelete()
    {
        Province savedProvince = getSavedProvince();
        this.repository.delete(savedProvince.getId());
        eGetAll();
    }

    @Test
    public void eGetAll()
    {
        Set<Province> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}