package com.djohannes.ac.za.domain;

public class Address
{
    private String id, no, street;

    private Address()
    {}

    public Address(Builder builder)
    {
        this.no=builder.no;
        this.street =builder.street;
        this.id=builder.id;
    }

    public String getNo() {
        return no;
    }

    public String getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public static class Builder
    {
        private String id, no, street;

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

        public Builder id(String id)
        {
            this.id =id;
            return this;
        }

        public Builder copy(Address address)
        {
            this.no=address.no;
            this.street=address.street;
            this.id=address.id;
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
