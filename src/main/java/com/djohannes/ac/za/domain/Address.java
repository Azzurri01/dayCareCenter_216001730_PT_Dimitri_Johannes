package com.djohannes.ac.za.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.Set;

@EntityScan
public class Address implements Comparable<Address>
{
    @Id
    private String id;
    private String no, street;
    private Address address;
    private Suburb suburb;
    private City city;
    private Province province;
    private Set<Daycare> daycares;

    private Address() {
    }

    private Address(Builder builder)
    {
        this.id=builder.id;
        this.no=builder.no;
        this.street=builder.street;
        this.suburb=builder.suburb;
        this.city=builder.city;
        this.province=builder.province;
    }

    public String getId() {
        return id;
    }

    public String getNo() {
        return no;
    }

    public String getStreet() {
        return street;
    }

    public Suburb getSuburb() {
        return suburb;
    }

    public City getCity() {
        return city;
    }

    public Province getProvince() {
        return province;
    }

    public static class Builder
    {
        private String id, no, street;
        private Suburb suburb;
        private City city;
        private Province province;
        private Set<Daycare> daycares;

        public Builder copy(Address address)
        {
            this.id= address.id;
            this.no=address.no;
            this.street=address.street;
            this.suburb= address.suburb;
            this.city= address.city;
            this.province= address.province;
            return this;
        }

        public Builder id(String id)
        {
            this.id =id;
            return this;
        }

        public Builder no(String no)
        {
            this.no =no;
            return this;
        }

        public Builder street(String str)
        {
            this.street =str;
            return this;
        }

        public Builder suburb(Suburb suburb)
        {
            this.suburb=suburb;
            return this;
        }

        public Builder city(City city)
        {
            this.city=city;
            return this;
        }

        public Builder province(Province province)
        {
            this.province=province;
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
                "Id='" + id + '\'' +
                "No='" + no + '\'' +
                "Street='" + street + '\'' +
                "Suburb='" + suburb.getName().getname() + '\'' +
                "City='" + city.getName().getname() + '\'' +
                "Province='" + province.getName().getname() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id.equals(address.id);
    }

    @Override
    public int hashCode()
            
    {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Address address) {
        return this.id.compareToIgnoreCase(address.id);
    }
}