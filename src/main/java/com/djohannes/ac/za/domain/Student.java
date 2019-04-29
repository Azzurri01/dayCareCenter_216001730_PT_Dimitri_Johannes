package com.djohannes.ac.za.domain;

import java.util.Objects;
import java.util.Set;

public class Student{

    private String studentId, studentFirstName, studentLastName;
    private int age;

    private Student() { }

    private Student(Builder builder) {
        this.studentId = builder.studentId;
        this.age = builder.age;
        this.studentFirstName = builder.studentFirstName;
        this.studentLastName = builder.studentLastName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public int getAge() {
        return age;
    }

    public static class Builder {

        private String studentId, studentFirstName, studentLastName;
        private int age;

        public Builder studentId( String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder studentFirstName( String studentFirstName) {
            this.studentFirstName = studentFirstName;
            return this;
        }

        public Builder studentLastName( String studentLastName) {
            this.studentLastName = studentLastName;
            return this;
        }

        public Builder age( int age) {
            this.age = age;
            return this;
        }


        public Student build() {
            return new Student(this);
        }

    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", StudentFirstName='" + studentFirstName + '\'' +
                ", StudentLastName='" + studentLastName + '\'' +
                ", age=" + age +
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
