package com.djohannes.ac.za.domain;
import java.util.Objects;

public class Parent
{
    private String employer, contact;

    private Parent()
    {

    }

    public String getEmployer() {
        return employer;
    }

    public String getContact() {
        return contact;
    }

     public Parent(Builder build)
    {
        this.employer=build.employer;

    }

    public static class Builder
    {
        private String employer, contact;

        public Builder getEmployer(String employer)
        {
            this.employer=employer;
            return this;
        }

        public Builder getContact(String contact)
        {
            this.contact=contact;
            return this;
        }

        public Parent build()
        {
            return new Parent(this);
        }
    }

    @Override
    public String toString() {
        return "Parent{" +
                "employer='" + employer + '\'' +
                "contact='" + contact + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parent parent= (Parent) o;
        return contact.equals(parent.contact);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(contact);
    }
}
