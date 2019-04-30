package com.djohannes.ac.za.domain;

public class Population
{
    private int total;

    public Population() {
    }

    public Population(Builder builder)
    {
        this.total=builder.total;
    }

    public int getTotal() {
        return total;
    }

    public static class Builder
    {
        private int total;

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
