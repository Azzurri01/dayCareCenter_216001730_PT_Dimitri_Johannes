package com.djohannes.ac.za.domain;

public class Name {
    private String fName, lName, name;

    private Name()
    {
    }

    public Name(Builder builder)
    {
        this.fName = builder.fName;
        this.lName=builder.lName;
        this.name=builder.name;
    }

    public String getFirstName() {
        return fName;
    }

    public String getLastName() {
        return lName;
    }

    public String getname() {
        return name;
    }

    public static class Builder {
        private String fName, lName, name;

        public Builder name(String name) {
            this.fName = name;
            return this;
        }

        public Builder surname(String surname) {
            this.lName = surname;
            return this;
        }

        public Builder orgName(String name)
        {
            this.name = name;
            return this;
        }

        public Name build()
        {
            return new Name(this);
        }
    }

    @Override
    public String toString() {
        return "Name{" +
                "First name='" + fName + '\'' +
                "Last name='" + lName + '\'' +
                "Name='" + name + '\'' +
                '}';
    }
}

