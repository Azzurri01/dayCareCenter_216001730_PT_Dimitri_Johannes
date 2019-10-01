package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.service.AddressService;
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
public class AddressServiceImplTest {

    @Autowired
    @Qualifier("AddressServiceImpl")
    private AddressService addressService;
    private Address address;
    private Set<Address> addresses = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        Name name = NameFactory.getName("Heideveld");
        Population population = PopulationFactory.getTotal(100000);
        Suburb suburb = SuburbFactory.getSuburb("7764", name, population);
        City city = CityFactory.getCity(name, population);
        Province province = ProvinceFactory.getProvince(name, population);
        Address address = AddressFactory.getAddress("14", "Sentinel Road", suburb, city, province);
        addresses.add(address);
    }

    @Test
    public void aCreate() {
        Name name = NameFactory.getName("Heideveld");
        Population population = PopulationFactory.getTotal(100000);
        Suburb suburb = SuburbFactory.getSuburb("7764", name, population);
        City city = CityFactory.getCity(name, population);
        Province province = ProvinceFactory.getProvince(name, population);
        Address address = AddressFactory.getAddress("14", "Sentinel Road", suburb, city, province);

        Address addService = addressService.create(address);
        Assert.assertNotNull(addService);
        addresses.add(addService);
    }

    @Test
    public void cUpdate() {
        String newStreetName = "6th Avenue";
        Address updated = addressService.update(new Address.Builder().copy(address).street(newStreetName).build());
        System.out.println("In update, updated = " + updated);
        addresses.add(updated);
        Assert.assertEquals(updated.getId(), addressService.read(updated.getId()));
    }

    @Test
    public void eDelete() {
        int total = addresses.size();
        System.out.println("Before deleting object: " + address.getId());
        addresses.remove(address.getId());
        System.out.println("After deleting object: " + address.getId());
        Assert.assertEquals(total, addresses.size() - 1);
    }

    @Test
    public void bRead()
    {
        Address readAddress = addressService.read(address.getId());
        System.out.println("readAddress id: " + readAddress.getId());
        System.out.println("addressService id: " + addressService.read(readAddress.getId()));
        Assert.assertEquals(readAddress.getId(), addressService.read(readAddress.getId()));
    }

    @Test
    public void dGetAll()
    {
        List<Address> addressList = addressService.getAll();
        System.out.println("Display all objects: " + addressList.toString());
        Assert.assertEquals(addressList.size(), addressService.getAll().size());
    }

}