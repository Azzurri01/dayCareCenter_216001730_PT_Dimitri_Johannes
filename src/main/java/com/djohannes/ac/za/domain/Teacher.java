package com.djohannes.ac.za.domain;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.Set;

//@Entity
public class Teacher implements Comparable<Teacher>
{
    @Id
    private String id;
    private Name name;
    private Contact contact;
    Set<Student> students;

    private Teacher()
    {

    }

    private Teacher(Builder builder)
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

        public Builder copy(Teacher teacher)
        {
            this.id=teacher.id;
            this.name=teacher.name;
            this.contact=teacher.contact;
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

        public Builder contact(Contact contact)
        {
            this.contact=contact;
            return this;
        }

        public Teacher build()
        {
            return new Teacher(this);
        }
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "Id='" + id + '\'' +
                "Name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher= (Teacher) o;
        return id.equals(teacher.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Teacher teacher) {
        return this.id.compareToIgnoreCase(teacher.id);
    }
}
