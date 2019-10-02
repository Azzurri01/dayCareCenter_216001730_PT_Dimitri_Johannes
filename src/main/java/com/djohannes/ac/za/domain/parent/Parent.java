package com.djohannes.ac.za.domain.parent;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Parent implements Comparable<Parent>
{

    @Id
    private String Id;
    private String fName, lName, gender, dob;
    private int age;

    private Parent()
    { }

    private Parent(Builder builder) {
        this.Id = builder.Id;
        this.fName = builder.fName;
        this.lName = builder.lName;
        this.gender = builder.gender;
        this.dob = builder.dob;
        this.age = builder.age;
    }

    public String getId() {
        return Id;
    }

    public String getFirstName()
    {
        return fName;
    }

    public String getLastName()
    {
        return lName;
    }

    public String getGender() {
        return gender;
    }

    public String getDob()
    {
        return dob;
    }

    public int getAge() {
        return age;
    }


    public static class Builder {

        private String Id;
        private String fName, lName, gender, dob;
        private int age;

        public Builder copy(Parent parent)
        {
            this.Id = parent.Id;
            this.fName = parent.fName;
            this.lName = parent.lName;
            this.gender = parent.gender;
            this.dob = parent.dob;
            this.age = parent.age;
            return this;
        }

        public Builder id(String parentId) {
            this.Id = Id;
            return this;
        }

        public Builder firstName(String fName) {
            this.fName = fName;
            return this;
        }

        public Builder lastName(String lName) {
            this.lName = lName;
            return this;
        }

        public Builder gender(String gender)
        {
            this.gender=gender;
            return this;
        }

        public Builder dateOfBirth(String dob)
        {
            this.dob=dob;
            return this;
        }

        public Builder age(int age)
        {
            this.age=age;
            return this;
        }

        public Parent build() {
            return new Parent(this);
        }

    }

    @Override
    public String toString() {
        return "Parent{" +
                "Id='" + Id + '\'' +
                ", Parent First Name='" + fName + '\'' +
                ", Parent Last Name='" + fName + '\'' +
                ", Date of birth=" + dob +
                ", Gender=" + gender +
                ", Age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parent parent = (Parent) o;
        return Id.equals(parent.Id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(Id);
    }

    @Override
    public int compareTo(Parent parent) {
        return this.Id.compareToIgnoreCase(parent.Id);
    }
}

