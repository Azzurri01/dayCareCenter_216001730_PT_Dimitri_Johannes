package com.djohannes.ac.za.domain;
import java.util.Objects;

public class City
{
    private String name, id;


    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public City(Builder builder)
    {
        this.id=builder.id;
        this.name =builder.name;
    }

    public static class Builder
    {
        private String name, id;

        public Builder getID(String id)
        {
            this.id=id;
            return this;
        }

        public Builder getName(String name)
        {
            this.name =name;
            return this;
        }

        public City build()
        {
            return new City(this);
        }
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City City = (City) o;
        return id.equals(City.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}
