package com.djohannes.ac.za.domain;

public class Student {
    private int id;

    private Student() {
    }

    public int getID() {
        return id;
    }

    public Student(Builder builder)
    {
        this.id = builder.id;
    }

    public static class Builder {
        private int id;

        public Builder getID(int id) {
            return this;
        }

        public Student build()
        {
            return new Student(this);
        }
    }
}

