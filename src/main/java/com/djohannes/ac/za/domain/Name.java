package com.djohannes.ac.za.domain;

import java.util.Objects;

public class Name {
    private String id, fName, lName, name;

    private Name(String id, String fName, String lName)
    {
        this.id=id;
        this.fName=fName;
        this.lName=lName;
    }

    private Name(String id, String name)
    {
        this.id=id;
        this.name=name;
    }

    public Name(Builder builder)
    {
        this.id=builder.id;
        this.fName = builder.fName;
        this.lName=builder.lName;
        this.name=builder.name;
    }

    public String getId() {
        return id;
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
        private String id, fName, lName, name;

        public Builder copy(Name name)
        {
            this.id=name.id;
            this.fName=name.fName;
            this.lName=name.lName;
            return this;
        }

        public Builder copy1(Name name)
        {
            this.id=name.id;
            this.name=name.name;
            return this;
        }

        public Builder id(String id) {
            this.id=id;
            return this;
        }

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
                '}';
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return id.equals(name.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }*/
}

