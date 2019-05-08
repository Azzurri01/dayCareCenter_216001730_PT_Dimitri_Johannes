package com.djohannes.ac.za.factory;

        import com.djohannes.ac.za.domain.*;
        import org.junit.Assert;
        import org.junit.Test;

        import java.util.Date;

        import static org.junit.Assert.*;

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
        Assert.assertEquals("Naqeeb", account.getStudent().getName().getFirstName());
        Assert.assertEquals("Dimitri", account.getParent().getName().getFirstName());
    }
}