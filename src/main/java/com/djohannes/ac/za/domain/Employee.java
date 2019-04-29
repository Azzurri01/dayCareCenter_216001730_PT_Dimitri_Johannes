package com.djohannes.ac.za.domain;
import java.util.Objects;

public class Employee
{
<<<<<<< HEAD
    private String id;
=======
    private int id;
>>>>>>> f36dbde0fbcd5e4d49bd3de4e3a5dd476a0f17cc

    private Employee()
    {

    }

<<<<<<< HEAD
    public String getID() {
=======
    public int getID() {
>>>>>>> f36dbde0fbcd5e4d49bd3de4e3a5dd476a0f17cc
        return id;
    }


    public Employee(Builder builder)
    {
        this.id=builder.id;

    }

    public static class Builder
    {
<<<<<<< HEAD
        private String id;

        public Builder getID(String id)
=======
        private int id;

        public Builder getID(int id)
>>>>>>> f36dbde0fbcd5e4d49bd3de4e3a5dd476a0f17cc
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
