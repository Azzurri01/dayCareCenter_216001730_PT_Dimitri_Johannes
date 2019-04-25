package com.djohannes.ac.za.domain;

public class Student1 {
    private int id;

    private Student1() {
    }

    public int getID() {
        return id;
    }

    public Student1(Builder builder)
    {
        this.id = builder.id;
    }

    public static class Builder {
        private int id;

        public Builder getID(int id) {
            return this;
        }

        public Student1 build()
        {
            return new Student1(this);
        }
    }
}

