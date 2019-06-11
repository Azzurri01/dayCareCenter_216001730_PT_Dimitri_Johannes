package com.djohannes.ac.za.domain;

import java.util.Date;
import java.util.Objects;

public class Account
{
    private String id;
    private Date openDate;
    private Student student;
    private Parent parent;
    private double fee;
    private double balance;

    public Account() {
    }

    public Account(Builder builder)
    {
        this.id=builder.id;
        this.openDate=builder.openDate;
        this.student=builder.student;
        this.parent=builder.parent;
        this.fee=builder.fee;
        this.balance=builder.balance;
    }

    public String getId() {
        return id;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public Student getStudent() {
        return student;
    }

    public Parent getParent() {
        return parent;
    }

    public double getFee() {
        return fee;
    }

    public double getBalance() {
        return balance;
    }

    public static class Builder
    {
        private String id;
        private Date openDate;
        private Student student;
        private Parent parent;
        private double fee;
        private double balance;

        public Builder copy(Account account)
        {
            this.id=account.id;
            this.openDate=account.openDate;
            this.student=account.student;
            this.parent=account.parent;
            this.fee=account.fee;
            this.balance=account.balance;
            return this;
        }

        public Builder id(String id)
        {
            this.id=id;
            return this;
        }

        public Builder openDate(Date oDate)
        {
            this.openDate=oDate;
            return this;
        }

        public Builder student(Student stu)
        {
            this.student=stu;
            return this;
        }

        public Builder parent(Parent par)
        {
            this.parent=par;
            return this;
        }

        public Builder fee(double fee)
        {
            this.fee=fee;
            return this;
        }

        public Builder balance(double bal)
        {
            this.balance=bal;
            return this;
        }

        public Account build()
        {
            return new Account(this);
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "Account number='" + id + '\'' +
                ", Open date='" + openDate + '\'' +
                ", Student='" + student + '\'' +
                ", Parent='" + parent + '\'' +
                ", fee='" + fee + '\'' +
                ", Balance='" + balance + '\'' +
                '}';
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id.equals(account.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }*/
}
