package com.djohannes.ac.za.domain;
import java.util.Objects;

public class Employee
{
    private String id;

    private Employee()
    {

    }

    public String getID() {
        return id;
    }


    public Employee(Builder builder)
    {
        this.id=builder.id;

    }

    public static class Builder
    {
        private String id;

        public Builder getID(String id)
        {
            this.id=id;
            return this;
        }

        public Employee build()
        {
            return new Employee(this);
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee= (Employee) o;
        return id.equals(employee.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}
