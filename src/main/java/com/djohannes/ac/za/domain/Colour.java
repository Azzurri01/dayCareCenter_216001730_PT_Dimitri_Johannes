package com.djohannes.ac.za.domain;

public class Colour
{
    private String colour;
    private Evaluation evaluation;

    public Colour() {
    }

    public Colour(Builder builder)
    {
        this.colour =builder.colour;
        this.evaluation=builder.evaluation;
    }

    public String getColour() {
        return colour;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public static class Builder
    {
        private String colour;
        private Evaluation evaluation;

        public Builder colour(String colour)
        {
            this.colour=colour;
            return this;
        }

        public Builder evaluation(Evaluation evaluation)
        {
            this.evaluation=evaluation;
            return this;
        }

        public Colour build()
        {
            return new Colour(this);
        }
    }

    @Override
    public String toString() {
        return "Colour{" +
                "Colour='" + colour + '\'' +
                ", Evaluation='" + evaluation + '\'' +
                '}';
    }
}
