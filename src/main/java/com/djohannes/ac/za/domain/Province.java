package com.djohannes.ac.za.domain;

import java.util.Set;

public class Province
{
    private String id;
    private Name name;
    private Population population;
    private Set<City> cities;

    private Province()
    {}

    public Province(Builder builder)
    {
        this.id=builder.id;
        this.name=builder.name;
        this.population=builder.population;
    }

    public String getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Population getPopulation() {
        return population;
    }

    public static class Builder
    {
        private String id;
        private Name name;
        private Population population;
        private Set<City> cities;

        public Builder id(String id)
        {
            this.id=id;
            return this;
        }

        public Builder name(Name name)
        {
            this.name=name;
            return this;
        }

        public Builder population(Population total)
        {
            this.population=total;
            return this;
        }
        public Province build()
        {
            return new Province(this);
        }
    }

    @Override
    public String toString() {
        return "Province{" +
                "id='" + id +'\'' +
                "Name='" + name + '\'' +
                "Population='" + population + '\'' +
                '}';
    }
}
