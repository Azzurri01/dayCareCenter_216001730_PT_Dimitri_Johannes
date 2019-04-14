package com.djohannes.ac.za.domain;

public class Teacher
{
    private String tTitle, tName, tSurname;
    private int tEmpNum;

    private Teacher()
    {

    }

    public String gettTitle() {
        return tTitle;
    }

    public String gettName() {
        return tName;
    }

    public String gettSurname() {
        return tSurname;
    }

    public int gettEmpCode() {
        return tEmpNum;
    }

    public Teacher(Builder builder)
    {
        this.tTitle=builder.tTitle;
        this.tName=builder.tName;
        this.tSurname=builder.tSurname;
        this.tEmpNum=builder.tEmpNum;
    }

    public static class Builder
    {
        private String tTitle, tName, tSurname;
        private int tEmpNum;

        public Builder getTitle(String title)
        {
            this.tTitle=title;
            return this;
        }

        public Builder getName(String name)
        {
            this.tName=name;
            return this;
        }

        public Builder getSurname(String surname)
        {
            this.tSurname=surname;
            return this;
        }

        public Builder getEmpNum(int empNum)
        {
            this.tEmpNum=empNum;
            return this;
        }

        public Teacher build()
        {
            return new Teacher(this);
        }
    }
}
