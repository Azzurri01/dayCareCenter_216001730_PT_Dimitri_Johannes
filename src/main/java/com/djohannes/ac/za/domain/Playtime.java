package com.djohannes.ac.za.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@EntityScan
public class Playtime implements Comparable<Playtime>
{
    @Id
    private String id;
    private String behaviour;

    private Playtime() {
    }

    private Playtime(Builder builder)
    {
        this.id=builder.id;
        this.behaviour =builder.behaviour;
    }

    public String getId() {
        return id;
    }

    public String getBehaviour() {
        return behaviour;
    }


    public static class Builder
    {
        private String id, behaviour;

        public Builder copy(Playtime playtime)
        {
            this.id=playtime.id;
            this.behaviour=playtime.behaviour;
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

    @Override
    public int compareTo(Playtime playtime) {
        return this.id.compareToIgnoreCase(playtime.id);
    }
}
