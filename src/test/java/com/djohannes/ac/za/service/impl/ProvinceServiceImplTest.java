package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.service.ProvinceService;
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
public class ProvinceServiceImplTest {

    @Autowired
    @Qualifier("ProvinceServiceImpl")
    private ProvinceService provinceService;
    private Province province;
    private Set<Province> provinces = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        Name name = NameFactory.getName("Western Province");
        Population population = PopulationFactory.getTotal(10000000);
        province = ProvinceFactory.getProvince(name, population);
        provinces.add(province);
    }

    @Test
    public void aCreate() {
        Name name1 = NameFactory.getName("Gauteng Province");
        Population population1 = PopulationFactory.getTotal(3000000);
        Province proService = provinceService.create(ProvinceFactory.getProvince(name1, population1));
        System.out.println("Created province: " + proService.getName());
        Assert.assertNotNull(proService);
        provinces.add(proService);
    }

    @Test
    public void cUpdate() {
        Population population2 = PopulationFactory.getTotal(5000000);
        Province updated = provinceService.update(new Province.Builder().copy(province).population(population2).build());
        System.out.println("In update, updated = " + updated);
        provinces.add(updated);
        Assert.assertEquals(updated.getId(), provinceService.read(updated.getId()));
    }

    @Test
    public void eDelete() {
        int total = provinces.size();
        System.out.println("Before deleting object: " + province.getId());
        provinces.remove(province.getId());
        System.out.println("After deleting object: " + province.getId());
        Assert.assertEquals(total, provinces.size() - 1);
    }

    @Test
    public void bRead()
    {
        Province readProvince = provinceService.read(province.getId());
        System.out.println("readProvince id: " + readProvince.getId());
        System.out.println("provinceService id: " + provinceService.read(readProvince.getId()));
        Assert.assertEquals(readProvince.getId(), provinceService.read(readProvince.getId()));
    }

    @Test
    public void dGetAll()
    {
        List<Province> provinceList = provinceService.getAll();
        System.out.println("Display all objects: " + provinceList.toString());
        Assert.assertEquals(provinceList.size(), provinceService.getAll().size());
    }

}