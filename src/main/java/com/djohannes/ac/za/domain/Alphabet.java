package com.djohannes.ac.za.domain;

import java.util.Objects;

public class Alphabet
{
    private String id, letter;
    private Evaluation evaluation;

    private Alphabet() {
    }

    private Alphabet(Builder builder)
    {
        this.id=builder.id;
        this.letter=builder.letter;
        this.evaluation=builder.evaluation;
    }

    public String getId() {
        return id;
    }

    public String getLetter() {
        return letter;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public static class Builder
    {
        private String id, letter;
        private Evaluation evaluation;

        public Builder copy(Alphabet alphabet)
        {
            this.id=alphabet.id;
            this.letter=alphabet.letter;
            this.evaluation=alphabet.evaluation;
            return this;
        }

        public Builder id(String id)
        {
            this.id=id;
            return this;
        }

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
                "id='" + id + '\'' +
                "Letter='" + letter + '\'' +
                ", Evaluation='" + evaluation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alphabet alphabet = (Alphabet) o;
        return id.equals(alphabet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
