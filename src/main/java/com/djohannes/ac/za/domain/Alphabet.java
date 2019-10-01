package com.djohannes.ac.za.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.Set;

//@Entity
public class Alphabet implements Comparable<Alphabet>
{
    @Id
    private String id;
    private String letter;

    private Alphabet() {
    }

    private Alphabet(Builder builder)
    {
        this.id=builder.id;
        this.letter=builder.letter;
    }

    public String getId() {
        return id;
    }

    public String getLetter() {
        return letter;
    }

    public static class Builder
    {
        private String id, letter;

        public Builder copy(Alphabet alphabet)
        {
            this.id=alphabet.id;
            this.letter=alphabet.letter;
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

    @Override
    public int compareTo(Alphabet alphabet) {
        return this.id.compareToIgnoreCase(alphabet.id);
    }
}
