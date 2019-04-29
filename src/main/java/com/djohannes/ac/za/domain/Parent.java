package com.djohannes.ac.za.domain;
import java.util.Objects;

public class Parent
{
<<<<<<< HEAD
    private String employer, contact;
=======
    private String employer;
>>>>>>> f36dbde0fbcd5e4d49bd3de4e3a5dd476a0f17cc

    private Parent()
    {

    }

    public String getEmployer() {
        return employer;
    }

<<<<<<< HEAD
    public String getContact() {
        return contact;
    }

=======
>>>>>>> f36dbde0fbcd5e4d49bd3de4e3a5dd476a0f17cc
     public Parent(Builder build)
    {
        this.employer=build.employer;

    }

    public static class Builder
    {
<<<<<<< HEAD
        private String employer, contact;

        public Builder getEmployer(String employer)
        {
            this.employer=employer;
            return this;
        }

        public Builder getContact(String contact)
        {
            this.contact=contact;
=======
        private String employer;

        public Builder getEmployer(String employer)
        {
            this.employer=employer;
>>>>>>> f36dbde0fbcd5e4d49bd3de4e3a5dd476a0f17cc
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
