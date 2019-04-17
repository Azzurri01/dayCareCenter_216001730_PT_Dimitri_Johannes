package com.djohannes.ac.za.domain;

public class Employee
{
    private int id;

    private Employee()
    {

    }

    public int getID() {
        return id;
    }


    public Employee(Builder builder)
    {
        this.id=builder.id;

    }

    public static class Builder
    {
        private int id;

        public Builder getID(int id)
        {
            this.id=id;
            return this;
        }

        public Employee build()
        {
            return new Employee(this);
        }
    }
}
