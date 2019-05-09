package com.djohannes.ac.za.factory;

        import com.djohannes.ac.za.domain.*;
        import org.junit.Assert;
        import org.junit.Test;

public class AccountFactoryTest {

    @Test
    public void getAccount()
    {
        Name sName = NameFactory.getName("Naqeeb", "Johannes");
        Name pName = NameFactory.getName("Dimitri", "Johannes");
        Grade grade = GradeFactory.getGrade("R");
        Address address = AddressFactory.getAddress("14", "Sentinel road");
        Contact pContact = ContactFactory.getContact("0824512653", "dimitri.johannes@gmail.com");
        Parent parent = ParentFactory.getParent(pName, pContact);
        Student student = StudentFactory.getStudent(sName, grade, "male", 5, address, parent);

        Account account = AccountFactory.getAccount(student, parent, 200.0, 0.0);
        Assert.assertNotNull(account.getId());
        Assert.assertEquals(sName.getFirstName(), account.getStudent().getName().getFirstName());
        Assert.assertEquals(sName.getLastName(), account.getStudent().getName().getLastName());
        Assert.assertEquals(pName.getFirstName(), account.getParent().getName().getFirstName());
        Assert.assertEquals(pName.getLastName(), account.getParent().getName().getLastName());
        //Assert.assertSame(200.0, account.getFee());
        //Assert.assertSame(0.0, account.getBalance());
    }
}