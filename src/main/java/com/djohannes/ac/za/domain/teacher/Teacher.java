package com.djohannes.ac.za.domain.teacher;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Teacher implements Comparable<Teacher>
{
    @Id
    private String Id;
    private String fName, lName, gender, dob;
    private int age;

    private Teacher()
    { }

    private Teacher(Builder builder) {
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

        public Builder copy(Teacher teacher)
        {
            this.Id = teacher.Id;
            this.fName = teacher.lName;
            this.lName = teacher.lName;
            this.gender = teacher.gender;
            this.dob = teacher.dob;
            this.age = teacher.age;
            return this;
        }

        public Builder id(String teacherId) {
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

        public Teacher build() {
            return new Teacher(this);
        }

    }

    @Override
    public String toString() {
        return "Teacher{" +
                "Id='" + Id + '\'' +
                ", Teacher First Name='" + fName + '\'' +
                ", Teacher Last Name='" + fName + '\'' +
                ", Date of birth=" + dob +
                ", Gender=" + gender +
                ", Age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Id.equals(teacher.Id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(Id);
    }

    @Override
    public int compareTo(Teacher teacher) {
        return this.Id.compareToIgnoreCase(teacher.Id);
    }
}

