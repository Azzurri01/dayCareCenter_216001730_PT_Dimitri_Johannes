package com.djohannes.ac.za.domain;

public class Parent
{
    private String pName, pSurname, pPhone;

    private Parent()
    {

    }

    public String getpName() {
        return pName;
    }

    public String getpSurname() {
        return pSurname;
    }

    public String getpPhone() {
        return pPhone;
    }

    public Parent(Builder build)
    {
        this.pName=build.pName;
        this.pSurname=build.pSurname;
        this.pPhone= build.pPhone;
    }

    public static class Builder
    {
        private String pName, pSurname, pPhone;

        public Builder getName(String name)
        {
            this.pName=name;
            return this;
        }

        public Builder getSurname(String surname)
        {
            this.pSurname=surname;
            return this;
        }

        public Builder getPhone(String phone)
        {
            this.pPhone=phone;
            return this;
        }

        public Parent build()
        {
            return new Parent(this);
        }
    }
}
