package com.djohannes.ac.za.domain;

public class Playtime
{
    private String behaviour;
    private Evaluation evaluation;

    public Playtime() {
    }

    public Playtime(Builder builder)
    {
        this.behaviour =builder.behaviour;
        this.evaluation=builder.evaluation;
    }

    public String getBehaviour() {
        return behaviour;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public static class Builder
    {
        private String behaviour;
        private Evaluation evaluation;

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
                "Behaviour='" + behaviour + '\'' +
                ", Evaluation='" + evaluation + '\'' +
                '}';
    }
}
