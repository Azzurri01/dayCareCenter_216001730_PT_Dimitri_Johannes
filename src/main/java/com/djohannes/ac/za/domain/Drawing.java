package com.djohannes.ac.za.domain;

public class Drawing
{
    private String shape;
    private Evaluation evaluation;

    public Drawing() {
    }

    public Drawing(Builder builder)
    {
        this.shape=builder.shape;
        this.evaluation=builder.evaluation;
    }

    public String getShapes() {
        return shape;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public static class Builder
    {
        private String shape;
        private Evaluation evaluation;

        public Builder drawing(String shape)
        {
            this.shape =shape;
            return this;
        }

        public Builder evaluation(Evaluation evaluation)
        {
            this.evaluation=evaluation;
            return this;
        }

        public Drawing build()
        {
            return new Drawing(this);
        }
    }

    @Override
    public String toString() {
        return "Drawing{" +
                "shapes='" + shape + '\'' +
                ", Evaluation='" + evaluation + '\'' +
                '}';
    }
}
