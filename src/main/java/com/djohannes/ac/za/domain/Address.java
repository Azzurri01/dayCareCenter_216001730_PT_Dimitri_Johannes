package com.djohannes.ac.za.domain;

public class Address
{
    private String no, street;

    private Address()
    {}

    public Address(Builder builder)
    {
        this.no=builder.no;
        this.street =builder.street;
    }

    public String getNo() {
        return no;
    }

    public String getStreet() {
        return street;
    }

    public static class Builder
    {
        private String no, street;

        public Builder streetNo(String no)
        {
            this.no=no;
            return this;
        }

        public Builder streetName(String street)
        {
            this.street =street;
            return this;
        }

        public Address build()
        {
            return new Address(this);
        }
    }

    @Override
    public String toString() {
        return "Address{" +
                "no='" + no +'\'' +
                "Street name='" + street + '\'' +
                '}';
    }
}
