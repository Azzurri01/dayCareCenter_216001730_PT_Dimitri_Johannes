package com.djohannes.ac.za.domain;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "Bathroom{" +
                "Time='" + time + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bathroom bathroom = (Bathroom) o;
        return time.equals(bathroom.time);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(time);
    }
}
