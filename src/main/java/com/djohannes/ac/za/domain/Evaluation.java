package com.djohannes.ac.za.domain;

import java.util.Objects;

public class Evaluation
{
    private int mark;

    public Evaluation()
    {
    }

    public Evaluation(Builder builder)
    {
        this.mark=builder.mark;
    }

    public int getRating() {
        return mark;
    }

    public static class Builder
    {
        private int mark;

        public Builder rating(int mark)
        {
            this.mark=mark;
            return this;
        }

        public Evaluation build()
        {
            return new Evaluation(this);
        }
    }

    @Override
    public String toString() {
        return "Evaluation{" +
                "Rating='" + mark + '\'' +
                '}';
    }
}
