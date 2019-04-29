
package com.djohannes.ac.za.domain;
import java.util.Objects;
import java.util.Set;

public class Parent
{
    private Name name;
    private Contact contact;
    private Set<Student> children;

    private Parent()
    {

    }

    public Parent(Builder builder)
    {
        this.name=builder.name;

    }

    public Name getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }

    public static class Builder
    {
        private Name name;
        private Contact contact;
        private Set<Student> children;

        public Builder name(Name name)
        {
            this.name=name;
            return this;
        }

        public Builder Contact(Contact contact)
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
                "Name='" + name + '\'' +
                "Contact='" + contact + '\'' +
                '}';
    }
}