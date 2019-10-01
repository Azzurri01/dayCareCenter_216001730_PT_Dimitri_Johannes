package com.djohannes.ac.za.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

//@Entity
public class Population implements Comparable<Population>
{
    @Id
    private String id;
    private int total;

    private Population() {
    }

    private Population(Builder builder)
    {
        this.id=builder.id;
        this.total=builder.total;
    }

    public String getId() {
        return id;
    }

    public int getTotal() {
        return total;
    }

    public static class Builder
    {
        private String id;
        private int total;

        public Builder copy(Population pop)
        {
            this.id=pop.id;
            this.total=pop.total;
            return this;
        }

        public Builder id(String id)
        {
            this.id=id;
            return this;
        }

        public Builder population(int total)
        {
            this.total=total;
            return this;
        }

        public Population build()
        {
            return new Population(this);
        }
    }

    @Override
    public String toString() {
        return "Population{" +
                "Id='" + id + '\'' +
                "Total='" + total + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Population population = (Population) o;
        return id.equals(population.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Population population) {
        return this.id.compareToIgnoreCase(population.id);
    }
}
