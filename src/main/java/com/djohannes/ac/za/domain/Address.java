package com.djohannes.ac.za.domain;

public class Address
{
    private String no, street, suburb;

    private Address()
    {}

    public Address(Builder builder)
    {
        this.no=builder.no;
        this.street =builder.street;
        this.suburb=builder.suburb;
    }

    public String getNo() {
        return no;
    }

    public String getStreet() {
        return street;
    }

    public String getSuburb() {
        return suburb;
    }

    public static class Builder
    {
        private String no, street, suburb;

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

        public Builder suburb(String suburb)
        {
            this.suburb =suburb;
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
                "Suburb='" + suburb + '\'' +
                '}';
    }
}
