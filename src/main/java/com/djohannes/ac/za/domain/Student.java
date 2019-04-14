package com.djohannes.ac.za.domain;

public class Student {
    private String sName, sSurname;
    private int sAge;

    private Student() {
    }

    public String getsName() {
        return sName;
    }

    public String getsSurname() {
        return sSurname;
    }

    public int getsAge() {
        return sAge;
    }

    public Student(Builder builder)
    {
        this.sName = builder.sName;
        this.sSurname = builder.sSurname;
        this.sAge = builder.sAge;
    }

    public static class Builder {
        private String sName, sSurname;
        private int sAge;

        public Builder getName(String name) {
            this.sName = name;
            return this;
        }

        public Builder getSurname(String surname) {
            this.sSurname = surname;
            return this;
        }

        public Builder getAge(int age) {
            this.sAge = age;
            return this;
        }

        public Student build()
        {
            return new Student(this);
        }
    }
}

