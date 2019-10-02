package com.djohannes.ac.za.domain.colour;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Colour implements Comparable<Colour>
{
    @Id
    private String id;
    private String colour;

    private Colour() {
    }

    private Colour(Builder builder)
    {
        this.id=builder.id;
        this.colour =builder.colour;
    }

    public String getId() {
        return id;
    }

    public String getColour() {
        return colour;
    }

    public static class Builder
    {
        private String id, colour;

        public Builder copy(Colour col)
        {
            this.id=col.id;
            this.colour=col.colour;
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

        public Colour build()
        {
            return new Colour(this);
        }
    }

    @Override
    public String toString() {
        return "Colour{" +
                "Id='" + id + '\'' +
                "Colour='" + colour + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colour colour = (Colour) o;
        return id.equals(colour.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Colour colour) {
        return this.id.compareToIgnoreCase(colour.id);
    }
}
