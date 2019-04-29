
package com.djohannes.ac.za.domain;

import java.util.Objects;
import java.util.Set;

public class Student{

    private String studentId, gender;
    private int age;
    private Name name;
    private Grade grade;
    private Address address;
    private Parent parent;

    private Student()
    { }

    private Student(Builder builder) {
        this.studentId = builder.studentId;
        this.name = builder.name;
        this.grade = builder.grade;
        this.age = builder.age;
        this.gender = builder.gender;
        this.address = builder.address;
        this.parent = builder.parent;
}

    public String getStudentId() {
        return studentId;
    }

    public Name getStudentName()
    {
        return name;
    }

    public Grade getGrade() {
        return grade;
    }

    public int getAge()
    {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Address getAddress()
    {
        return address;
    }

    public Parent getParent() {
        return parent;
    }

    public static class Builder {
        private String studentId, gender;
        private int age;
        private Name name;
        private Grade grade;
        private Address address;
        private Parent parent;

        public Builder studentId( String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder gender(String gender)
        {
            this.gender=gender;
            return this;
        }

        public Builder age(int age)
        {
            this.age=age;
            return this;
        }

        public Builder studentName(Name name) {
            this.name = name;
            return this;
        }

        public Builder grade(Grade grade) {
            this.grade = grade;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Builder parent(Parent parent)
        {
            this.parent=parent;
            return this;
        }

    public Student build() {
            return new Student(this);
        }

    }

    @Override
    public String toString() {
        return "Student{" +
                "student ID='" + studentId + '\'' +
                ", Student Name='" + name + '\'' +
                ", Grade='" + grade + '\'' +
                ", Gender=" + gender +
                ", Age=" + age +
                ", Address=" + age +
                ", Parent=" + parent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId.equals(student.studentId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(studentId);
    }
}