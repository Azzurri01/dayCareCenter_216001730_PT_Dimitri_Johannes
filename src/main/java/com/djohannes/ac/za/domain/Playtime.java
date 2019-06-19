package com.djohannes.ac.za.domain;

import java.util.Objects;

public class Playtime
{
    private String id, behaviour;
    private Evaluation evaluation;

    private Playtime() {
    }

    private Playtime(Builder builder)
    {
        this.id=builder.id;
        this.behaviour =builder.behaviour;
        this.evaluation=builder.evaluation;
    }

    public String getId() {
        return id;
    }

    public String getBehaviour() {
        return behaviour;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public static class Builder
    {
        private String id, behaviour;
        private Evaluation evaluation;

        public Builder copy(Playtime playtime)
        {
            this.id=playtime.id;
            this.behaviour=playtime.behaviour;
            this.evaluation=playtime.evaluation;
            return this;
        }

        public Builder id(String id)
        {
            this.id=id;
            return this;
        }

        public Builder social(String behaviour)
        {
            this.behaviour=behaviour;
            return this;
        }

        public Builder evaluation(Evaluation evaluation)
        {
            this.evaluation=evaluation;
            return this;
        }

        public Playtime build()
        {
            return new Playtime(this);
        }
    }

    @Override
    public String toString() {
        return "Playtime{" +
                "Id='" + id + '\'' +
                "Behaviour='" + behaviour + '\'' +
                ", Evaluation='" + evaluation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playtime playtime = (Playtime) o;
        return id.equals(playtime.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
