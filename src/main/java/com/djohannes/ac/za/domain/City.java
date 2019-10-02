package com.djohannes.ac.za.domain;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.Set;

@EntityScan
public class City implements Comparable<City>
{
    @Id
    private String id;
    private Name name;
    private Population population;
    private Set<Suburb> suburbs;

    private City() {
    }

    private City(Builder builder)
    {
        this.id=builder.id;
        this.name =builder.name;
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
        private Set<Suburb> suburbs;

        public Builder id(String id)
        {
            this.id=id;
            return this;
        }

        public Builder name(Name name)
        {
            this.name =name;
            return this;
        }

        public Builder population(Population total)
        {
            this.population=total;
            return this;
        }

        public Builder copy(City city)
        {
            this.id=city.id;
            this.name =city.name;
            this.population=city.population;
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
                "Id='" + id + '\'' +
                "Name='" + name + '\'' +
                "Population='" + population + '\'' +
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

    @Override
    public int compareTo(City city) {
        return this.id.compareToIgnoreCase(city.id);
    }
}
