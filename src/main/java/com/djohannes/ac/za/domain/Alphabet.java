package com.djohannes.ac.za.domain;

import java.util.Objects;

public class Alphabet
{
    private String letter;
    private Evaluation evaluation;

    public Alphabet() {
    }

    public Alphabet(Builder builder)
    {
        this.letter=builder.letter;
        this.evaluation=builder.evaluation;
    }

    public String getLetter() {
        return letter;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public static class Builder
    {
        private String letter;
        private Evaluation evaluation;

        public Builder letter(String letter)
        {
            this.letter=letter;
            return this;
        }

        public Builder evaluation(Evaluation evaluation)
        {
            this.evaluation=evaluation;
            return this;
        }

        public Alphabet build()
        {
            return new Alphabet(this);
        }
    }

    @Override
    public String toString() {
        return "Alphabet{" +
                "Letter='" + letter + '\'' +
                ", Evaluation='" + evaluation + '\'' +
                '}';
    }
}
