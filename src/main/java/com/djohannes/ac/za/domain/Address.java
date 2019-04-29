package com.djohannes.ac.za.domain;

public class Address
{
    private String street, no, suburb;

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
        private String street, no, suburb;

        public Builder getID(String no)
        {
            this.no=no;
            return this;
        }

        public Builder getName(String street)
        {
            this.street =street;
            return this;
        }

        public Builder getSuburb(String suburb)
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
