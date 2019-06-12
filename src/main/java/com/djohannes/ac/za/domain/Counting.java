package com.djohannes.ac.za.domain;

import java.util.Objects;

public class Counting
{
    private String id;
    private int number;
    private Evaluation evaluation;

    private Counting() {
    }

    private Counting(Builder builder)
    {
        this.id=builder.id;
        this.number =builder.number;
        this.evaluation=builder.evaluation;
    }

    public String getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public static class Builder
    {
        private String id;
        private int number;
        private Evaluation evaluation;

        public Builder copy(Counting counting)
        {
            this.id=counting.id;
            this.number=counting.number;
            this.evaluation=counting.evaluation;
            return this;
        }

        public Builder id(String id)
        {
            this.id=id;
            return this;
        }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Counting counting = (Counting) o;
        return id.equals(counting.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
