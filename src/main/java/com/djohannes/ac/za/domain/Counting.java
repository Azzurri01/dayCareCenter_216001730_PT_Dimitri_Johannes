package com.djohannes.ac.za.domain;

public class Counting
{
    private int number;
    private Evaluation evaluation;

    public Counting() {
    }

    public Counting(Builder builder)
    {
        this.number =builder.number;
        this.evaluation=builder.evaluation;
    }

    public int getNumber() {
        return number;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public static class Builder
    {
        private int number;
        private Evaluation evaluation;

        public Builder number(int number)
        {
            this.number=number;
            return this;
        }

        public Builder evaluation(Evaluation evaluation)
        {
            this.evaluation=evaluation;
            return this;
        }

        public Counting build()
        {
            return new Counting(this);
        }
    }

    @Override
    public String toString() {
        return "Counting{" +
                "Number='" + number + '\'' +
                ", Evaluation='" + evaluation + '\'' +
                '}';
    }
}
