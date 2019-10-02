package com.djohannes.ac.za.domain.address;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Address implements Comparable<Address>
{

    @Id
    private String Id;
    private String street, suburb, city, country;
    private int number;

    private Address()
    { }

    private Address(Builder builder) {
        this.Id = builder.Id;
        this.street = builder.street;
        this.suburb = builder.suburb;
        this.city = builder.city;
        this.country = builder.country;
        this.number = builder.number;
    }

    public String getId() {
        return Id;
    }

    public String getStreet()
    {
        return street;
    }

    public String getSuburb()
    {
        return suburb;
    }

    public String getCity() {
        return city;
    }

    public String getCountry()
    {
        return country;
    }

    public int getNumber() {
        return number;
    }


    public static class Builder {

        private String Id;
        private String street, suburb, city, country;
        private int number;

        public Builder copy(Address parent)
        {
            this.Id = parent.Id;
            this.street = parent.street;
            this.suburb = parent.suburb;
            this.city = parent.city;
            this.country = parent.country;
            this.number = parent.number;
            return this;
        }

        public Builder id(String parentId) {
            this.Id = Id;
            return this;
        }

        public Builder getStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder getSuburb(String suburb) {
            this.suburb = suburb;
            return this;
        }

        public Builder getCity(String city)
        {
            this.city=city;
            return this;
        }

        public Builder getCountry(String country)
        {
            this.country=country;
            return this;
        }

        public Builder number(int number)
        {
            this.number=number;
            return this;
        }

        public Address build() {
            return new Address(this);
        }

    }

    @Override
    public String toString() {
        return "Address{" +
                "Id='" + Id + '\'' +
                ", Number =" + number +
                ", Street ='" + street + '\'' +
                ", Suburb ='" + suburb + '\'' +
                ", Country =" + country +
                ", City =" + city +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address parent = (Address) o;
        return Id.equals(parent.Id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(Id);
    }

    @Override
    public int compareTo(Address parent) {
        return this.Id.compareToIgnoreCase(parent.Id);
    }
}


