package com.djohannes.ac.za.domain;

import java.util.Objects;

public class Drawing
{
    private String id, shape;
    private Evaluation evaluation;

    private Drawing() {
    }

    private Drawing(Builder builder)
    {
        this.id=builder.id;
        this.shape=builder.shape;
        this.evaluation=builder.evaluation;
    }

    public String getId() {
        return id;
    }

    public String getShapes() {
        return shape;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public static class Builder
    {
        private String id, shape;
        private Evaluation evaluation;

        public Builder copy(Drawing drawing)
        {
            this.id=drawing.id;
            this.shape=drawing.shape;
            this.evaluation=drawing.evaluation;
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
                "Id='" + id + '\'' +
                "shapes='" + shape + '\'' +
                ", Evaluation='" + evaluation + '\'' +
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
}
