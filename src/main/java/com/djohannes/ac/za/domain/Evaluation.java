package com.djohannes.ac.za.domain;

import java.util.Objects;

public class Evaluation
{
    private String id;
    private int mark;

    public Evaluation()
    {
    }

    public Evaluation(Builder builder)
    {
        this.id=builder.id;
        this.mark=builder.mark;
    }

    public int getRating() {
        return mark;
    }

    public String getId() {
        return id;
    }

    public static class Builder
    {
        private String id;
        private int mark;

        public Builder copy(Evaluation eval)
        {
            this.id=eval.id;
            this.mark=eval.mark;
            return this;
        }

        public Builder id(String id)
        {
            this.id=id;
            return this;
        }

        public Builder rating(int mark)
        {
            this.mark=mark;
            return this;
        }

        public Evaluation build()
        {
            return new Evaluation(this);
        }
    }

    @Override
    public String toString() {
        return "Evaluation{" +
                "Rating='" + mark + '\'' +
                '}';
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evaluation evaluation = (Evaluation) o;
        return id.equals(evaluation.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }*/
}
