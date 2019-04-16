package com.djohannes.ac.za.domain;

public class Bathroom
{
    private String time;

    private Bathroom()
    {}

    public String getBathroomBreak() {
        return time;
    }

    public Bathroom(Builder builder)
    {
        this.time=builder.time;
    }

    public static class Builder
    {
        private String time;

        public Builder getBathroomBreak(String time)
        {
            this.time=time;
            return this;
        }

        public Bathroom build()
        {
            return new Bathroom(this);
        }
    }

}
