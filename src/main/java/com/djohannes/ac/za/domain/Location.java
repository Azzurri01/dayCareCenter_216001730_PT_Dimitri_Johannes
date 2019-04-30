package com.djohannes.ac.za.domain;
import sun.tracing.ProbeSkeleton;

import java.util.Objects;
import java.util.Set;

public class Location
{
    private String id;
    private Address address;
    private Suburb suburb;
    private City city;
    private Province province;
    private Set<Daycare> daycares;

    public Location() {
    }

    public Location(Builder builder)
    {
    }

    public String getId() {
        return id;
    }

    public Address getAddress() {
        return address;
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
        private String id;
        private Address address;
        private Suburb suburb;
        private City city;
        private Province province;
        private Set<Daycare> daycares;

        public Builder id(String id)
        {
            this.id =id;
            return this;
        }

        public Builder address(Address address)
        {
            this.address=address;
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

        public Location build()
        {
            return new Location(this);
        }
    }

    @Override
    public String toString() {
        return "Location{" +
                "ID='" + id + '\'' +
                "Address='" + address + '\'' +
                "Suburb='" + suburb + '\'' +
                "City='" + city + '\'' +
                "Province='" + province + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location= (Location) o;
        return id.equals(location.id);
    }

    @Override
    public int hashCode()
            
    {
        return Objects.hash(id);
    }
}