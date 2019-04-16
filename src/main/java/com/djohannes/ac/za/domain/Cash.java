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
}
