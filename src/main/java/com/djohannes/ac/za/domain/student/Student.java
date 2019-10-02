package com.djohannes.ac.za.domain.student;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Student implements Comparable<Student>
{

    @Id
    private String Id;
    private String fName, lName, gender, dob;
    private int age;

    private Student()
    { }

    private Student(Builder builder) {
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

        public Builder copy(Student student)
        {
            this.Id = student.Id;
            this.fName = student.fName;
            this.lName = student.lName;
            this.gender = student.gender;
            this.dob = student.dob;
            this.age = student.age;
            return this;
        }

        public Builder id(String Id) {
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

        public Student build() {
            return new Student(this);
        }

    }

    @Override
    public String toString() {
        return "Student{" +
                "Id='" + Id + '\'' +
                ", Student First Name='" + fName + '\'' +
                ", Student Last Name='" + fName + '\'' +
                ", Date of birth=" + dob +
                ", Gender=" + gender +
                ", Age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Id.equals(student.Id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(Id);
    }

    @Override
    public int compareTo(Student student) {
        return this.Id.compareToIgnoreCase(student.Id);
    }
}

