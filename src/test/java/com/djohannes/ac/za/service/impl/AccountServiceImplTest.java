package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.service.AccountService;
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
public class AccountServiceImplTest {

    @Autowired
    @Qualifier("AccountServiceImpl")
    private AccountService accountService;
    private Account account;
    private Set<Account> accounts = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        Name sName = NameFactory.getName("Naqeeb", "Johannes");
        Name pName = NameFactory.getName("Dimitri", "Johannes");
        Grade grade = GradeFactory.getGrade("R");
        Contact pContact = ContactFactory.getContact("0824512653", "dimitri.johannes@gmail.com");
        Parent parent = ParentFactory.getParent(pName, pContact);

        Name name = NameFactory.getName("Heideveld");
        Population population = PopulationFactory.getTotal(100000);
        Suburb suburb = SuburbFactory.getSuburb("7764", name, population);
        City city = CityFactory.getCity(name, population);
        Province province = ProvinceFactory.getProvince(name, population);
        Address address = AddressFactory.getAddress("14", "Sentinel Road", suburb, city, province);

        Student student = StudentFactory.getStudent(sName, grade, "male", 5, address, parent);

        Account account = AccountFactory.getAccount(student, parent, 200.0, 0.0);

        accounts.add(account);
    }

    @Test
    public void aCreate() {
        Name sName1 = NameFactory.getName("Naqeeb", "Johannes");
        Name pName1 = NameFactory.getName("Dimitri", "Johannes");
        Grade grade1 = GradeFactory.getGrade("R");
        Contact pContact1 = ContactFactory.getContact("0824512653", "dimitri.johannes@gmail.com");
        Parent parent1 = ParentFactory.getParent(pName1, pContact1);

        Name name1 = NameFactory.getName("Heideveld");
        Population population1 = PopulationFactory.getTotal(100000);
        Suburb suburb1 = SuburbFactory.getSuburb("7764", name1, population1);
        City city1 = CityFactory.getCity(name1, population1);
        Province province1 = ProvinceFactory.getProvince(name1, population1);
        Address address1 = AddressFactory.getAddress("14", "Sentinel Road", suburb1, city1, province1);

        Student student1 = StudentFactory.getStudent(sName1, grade1, "male", 5, address1, parent1);

        Account account = AccountFactory.getAccount(student1, parent1, 200.0, 0.0);

        Account accService = accountService.create(AccountFactory.getAccount(student1, parent1, 500, 50));
        Assert.assertNotNull( accService);
        accounts.add( accService);
    }

    @Test
    public void cUpdate() {
        double newBal = 200;
        Account updated = accountService.update(new Account.Builder().copy(account).balance(newBal).build());
        System.out.println("In update, updated = " + updated);
        accounts.add(updated);
        Assert.assertEquals(updated.getId(), accountService.read(updated.getId()));
    }

    @Test
    public void eDelete() {
        int total = accounts.size();
        System.out.println("Before deleting object: " + account.getId());
        accounts.remove(account.getId());
        System.out.println("After deleting object: " + account.getId());
        Assert.assertEquals(total, accounts.size() - 1);
    }

    @Test
    public void bRead()
    {
        Account readAccount = accountService.read(account.getId());
        System.out.println("readAccount id: " + readAccount.getId());
        System.out.println("accountService id: " + accountService.read(readAccount.getId()));
        Assert.assertEquals(readAccount.getId(), accountService.read(readAccount.getId()));
    }

    @Test
    public void dGetAll()
    {
        List<Account> accountList = accountService.getAll();
        System.out.println("Display all objects: " + accountList.toString());
        Assert.assertEquals(accountList.size(), accountService.getAll().size());
    }

}
