package com.djohannes.ac.za.domain;

public class Deworm
{
    private String dInjection;

    private Deworm()
    {

    }

    public String getDeworming() {
        return dInjection;
    }

    public Deworm(Builder builder)
    {
        this.dInjection=builder.bInjection;
    }

    public static class Builder
    {
        private String bInjection;

        public Builder getInjection(String injection)
        {
            this.bInjection=injection;
            return this;
        }

        public Deworm build()
        {
            return new Deworm(this);
        }
    }
}
