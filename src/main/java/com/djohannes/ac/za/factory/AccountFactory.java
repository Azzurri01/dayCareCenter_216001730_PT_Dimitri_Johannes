package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.util.Misc;

import java.util.Date;

public class AccountFactory {


    public static Account getAccount(Student student, Parent parent, double fee, double bal) {
        return new Account.Builder()
                .id(Misc.generateId())
                //.openDate(openDate)
                .student(student)
                .parent(parent)
                .fee(fee)
                .balance(bal)
                .build();
    }
}
