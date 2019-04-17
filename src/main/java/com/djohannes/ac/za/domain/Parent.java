package com.djohannes.ac.za.domain;

public class Parent
{
    private String employer;

    private Parent()
    {

    }

    public String getEmployer() {
        return employer;
    }

     public Parent(Builder build)
    {
        this.employer=build.employer;

    }

    public static class Builder
    {
        private String employer;

        public Builder getEmployer(String employer)
        {
            this.employer=employer;
            return this;
        }

        public Parent build()
        {
            return new Parent(this);
        }
    }
}
