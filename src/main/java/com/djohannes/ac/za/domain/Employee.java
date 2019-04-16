package com.djohannes.ac.za.domain;

public class Employee
{
    private int empNo;
    private String name, surname;

    private Employee()
    {

    }

    public int getEmpNo() {
        return empNo;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Employee(Builder builder)
    {
        this.empNo=builder.empNo;
        this.name=builder.name;
        this.surname=builder.surname;
    }

    public static class Builder
    {
        private int empNo;
        private String name, surname;

        public Builder getEmpNo(int no)
        {
            this.empNo=no;
            return this;
        }

        public Builder getName(String name)
        {
            this.name=name;
            return this;
        }

        public Builder getSurname(String surname)
        {
            this.surname=surname;
            return this;
        }

        public Employee build()
        {
            return new Employee(this);
        }
    }
}
