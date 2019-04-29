package com.djohannes.ac.za.domain;

public class Name {
    private String fName, lName;

    private Name()
    {
    }

    public Name(Builder builder)
    {
        this.fName = builder.fName;
        this.lName=builder.lName;
    }

    public String getFirstName() {
        return fName;
    }

    public String getLastName() {
        return lName;
    }

    public static class Builder {
        private String fName, lName;

        public Builder getFirstName(String name) {
            this.fName = name;
            return this;
        }

        public Builder getPhone(String surname) {
            this.lName = surname;
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
                '}';
    }
}

