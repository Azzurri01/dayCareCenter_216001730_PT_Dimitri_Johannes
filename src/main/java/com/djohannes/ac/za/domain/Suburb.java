package com.djohannes.ac.za.domain;

import java.util.Objects;

public class Suburb
{
    private String id, areaCode;
    private Name name;
    private Population population;

    private Suburb()
    {

    }

    public Suburb(Builder builder)
    {
        this.id=builder.id;
        this.name=builder.name;
        this.areaCode=builder.areaCode;
        this.population=builder.population;
    }

    public String getId() {
        return id;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public Name getName() {
        return name;
    }

    public Population getPopulation() {
        return population;
    }

    public static class Builder
    {
        private String id, areaCode;
        private Name name;
        private Population population;

        public Builder copy(Suburb suburb)
        {
            this.id=suburb.id;
            this.name=suburb.name;
            this.areaCode=suburb.areaCode;
            this.population=suburb.population;
            return this;
        }

        public Builder id(String id)
        {
            this.id=id;
            return this;
        }

        public Builder code(String code)
        {
            this.areaCode=code;
            return this;
        }

        public Builder name(Name name)
        {
            this.name=name;
            return this;
        }

        public Builder population(Population population)
        {
            this.population=population;
            return this;
        }

        public Suburb build()
        {
            return new Suburb(this);
        }
    }

    @Override
    public String toString() {
        return "Suburb{" +
                "Name='" + name.getname() + " " + '\'' +
                "Postal code='" + areaCode + '\'' +
                '}';
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Suburb suburb = (Suburb) o;
        return id.equals(suburb.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }*/
}
