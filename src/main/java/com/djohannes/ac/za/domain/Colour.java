package com.djohannes.ac.za.domain;

public class Colour
{
    private String id, colour;
    private Evaluation evaluation;

    public Colour() {
    }

    public Colour(Builder builder)
    {
        this.id=builder.id;
        this.colour =builder.colour;
        this.evaluation=builder.evaluation;
    }

    public String getId() {
        return id;
    }

    public String getColour() {
        return colour;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public static class Builder
    {
        private String id, colour;
        private Evaluation evaluation;

        public Builder copy(Colour col)
        {
            this.id=col.id;
            this.colour=col.colour;
            this.evaluation=col.evaluation;
            return this;
        }

        public Builder colour(String colour)
        {
            this.colour=colour;
            return this;
        }

        public Builder id(String id)
        {
            this.id=id;
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
