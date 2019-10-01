
package com.djohannes.ac.za.domain;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.Set;

//@Entity
public class Parent implements Comparable<Parent>
{
    @Id
    private String id;
    private Name name;
    private Contact contact;
    private Set<Student> children;

    private Parent()
    {

    }

    private Parent(Builder builder)
    {
        this.id=builder.id;
        this.name=builder.name;
        this.contact=builder.contact;
    }

    public String getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }

    public static class Builder
    {
        private String id;
        private Name name;
        private Contact contact;
        private Set<Student> children;

        public Builder copy(Parent parent)
        {
            this.id=parent.id;
            this.name=parent.name;
            this.contact=parent.contact;
            return this;
        }

        public Builder id(String id)
        {
            this.id=id;
            return this;
        }

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
                "Id='" + id + '\'' +
                "Name='" + name + '\'' +
                "Contact='" + contact + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parent parent = (Parent) o;
        return id.equals(parent.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Parent parent) {
        return this.id.compareToIgnoreCase(parent.id);
    }
}