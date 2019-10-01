package com.djohannes.ac.za.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.Set;

//@Entity
public class Province implements Comparable<Province>
{
    @Id
    private String id;
    private Name name;
    private Population population;
    private Set<City> cities;

    private Province()
    {}

    private Province(Builder builder)
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

        public Builder copy(Province province)
        {
            this.id=province.id;
            this.name=province.name;
            this.population=province.population;
            return this;
        }

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
                "Id='" + id + '\'' +
                "Name='" + name + '\'' +
                "Population='" + population + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Province province = (Province) o;
        return id.equals(province.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Province province) {
        return this.id.compareToIgnoreCase(province.id);
    }
}
