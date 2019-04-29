package com.djohannes.ac.za.domain;

public class Cash
{
    private double amount;

    private Cash()
    {

    }

    public double getCash() {
        return amount;
    }

    public Cash(Builder builder)
    {
        this.amount=builder.amount;
    }

    public static class Builder
    {
        private double amount;

        public Builder getCash(double amt)
        {
            this.amount=amt;
            return this;
        }

        public Cash build()
        {
            return new Cash(this);
        }
    }

    @Override
    public String toString() {
        return "Cash{" +
                "Time='" + amount + '\'' +
                '}';
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cash Cash = (Cash) o;
        return amount.equals(Cash.amount);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(time);
    }*/
}
