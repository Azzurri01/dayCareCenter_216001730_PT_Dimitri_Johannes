package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.AccountRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountRepositoryImplTest {

    private AccountRepository repository;
    private Account account;

    Name sName = NameFactory.getName("Naqeeb", "Johannes");
    Name pName = NameFactory.getName("Dimitri", "Johannes");
    Grade grade = GradeFactory.getGrade("R");
    Address address = AddressFactory.getAddress("14", "Sentinel road");
    Contact pContact = ContactFactory.getContact("0824512653", "dimitri.johannes@gmail.com");
    Parent parent = ParentFactory.getParent(pName, pContact);
    Student student = StudentFactory.getStudent(sName, grade, "male", 5, address, parent);

    private Account getSavedAccount()
    {
        Set<Account> savedAccount = this.repository.getAll();
        return  savedAccount.iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = AccountRepositoryImpl.getRepository();
        this.account = AccountFactory.getAccount(student, parent, 500, 100);
    }

    @Test
    public void aCreate()
    {
        Account createdAccount = this.repository.create(this.account);
        System.out.println("Create method called: Created account = " + this.account);
        eGetAll();
        Assert.assertSame(createdAccount, this.account);
    }

    @Test
    public void bRead()
    {
        Account savedAccount = getSavedAccount();
        System.out.println("Read method call 1: Reading accountID = " + savedAccount.getId());
        Account readAccount = this.repository.read(savedAccount.getId());
        System.out.println("Read method call 2: Reading read = " + savedAccount.getId());
        eGetAll();
        Assert.assertSame(savedAccount, readAccount);
    }

    @Test
    public void cUpdate()
    {
        String newId = "112";
        Account streetNo = new Account.Builder().copy(getSavedAccount()).id(newId).build();
        System.out.println("In update, about_to_updated = " + account);
        Account updated = this.repository.update(account);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newId, updated.getId().toString());;
        eGetAll();
    }

    @Test
    public void dDelete()
    {
        Account savedAccount = getSavedAccount();
        this.repository.delete(savedAccount.getId());
        eGetAll();
    }

    @Test
    public void eGetAll()
    {
        Set<Account> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}