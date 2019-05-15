package com.djohannes.ac.za.domain;

public class Population
{
    private String id;
    private int total;

    public Population() {
    }

    public Population(Builder builder)
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
                "Total='" + total + '\'' +
                '}';
    }
}
