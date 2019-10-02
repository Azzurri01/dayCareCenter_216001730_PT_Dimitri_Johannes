package com.djohannes.ac.za.domain.drawing;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Drawing implements Comparable<Drawing>
{
    @Id
    private String id;
    private String shape;

    private Drawing() {
    }

    private Drawing(Builder builder)
    {
        this.id=builder.id;
        this.shape=builder.shape;
    }

    public String getId() {
        return id;
    }

    public String getShapes() {
        return shape;
    }

    public static class Builder
    {
        private String id, shape;

        public Builder copy(Drawing drawing)
        {
            this.id=drawing.id;
            this.shape=drawing.shape;
            return this;
        }

        public Builder id(String id)
        {
            this.id=id;
            return this;
        }

        public Builder drawing(String shape)
        {
            this.shape =shape;
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
                "Id='" + id + '\'' +
                "shapes='" + shape + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drawing drawing = (Drawing) o;
        return id.equals(drawing.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Drawing drawing) {
        return this.id.compareToIgnoreCase(drawing.id);
    }
}
