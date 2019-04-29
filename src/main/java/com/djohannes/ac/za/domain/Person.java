package com.djohannes.ac.za.domain;
<<<<<<< HEAD
import java.util.Objects;
=======
>>>>>>> f36dbde0fbcd5e4d49bd3de4e3a5dd476a0f17cc

public class Person {
    private String name, surname, phone;
    private char gender;
    private int age;

    private Person() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Person(Builder builder)
    {
        this.name = builder.name;
        this.surname = builder.surname;
        this.phone=builder.phone;
        this.gender=builder.gender;
        this.age = builder.age;
    }

    public static class Builder {

        private String name, surname, phone;
        private char gender;
        private int age;

        public Builder getName(String name) {
            this.name = name;
            return this;
        }

        public Builder getSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder getPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder getGender(char gender) {
            this.gender = gender;
            return this;
        }

        public Builder getAge(int age) {
            this.age = age;
            return this;
        }

        public Person build()
        {
            return new Person(this);
        }
    }
<<<<<<< HEAD
/*
    @Override
    public String toString() {
        return "Clinic{" +
                "injection='" + injection + '\'' +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deworm deworm= (Deworm) o;
        return id.equals(deworm.id);
    }

    @Override
    public int hashCode()

    {
        return Objects.hash(id);
    }
    */
=======
>>>>>>> f36dbde0fbcd5e4d49bd3de4e3a5dd476a0f17cc
}

