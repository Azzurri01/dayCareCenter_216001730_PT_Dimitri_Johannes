package com.djohannes.ac.za.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

//@Entity
public class Allergy implements Comparable<Allergy>
{
    @Id
    private String id;
    private String name;

    private Allergy()
    {
    }

    private Allergy(Builder builder)
    {
        this.name=builder.name;;
        this.id =builder.id;
    }

    public String getName()
    {
        return name;
    }

    public String getId()
    {
        return id;
    }

    public static class Builder
    {
        private String name, id;

        public Builder copy(Allergy allergy)
        {
            this.id=allergy.id;
            this.name=allergy.name;
            return this;
        }

        public Builder name(String name)
        {
            this.name=name;
            return this;
        }

        public Builder id(String id)
        {
            this.id =id;
            return this;
        }

        public Allergy build()
        {
            return new Allergy(this);
        }
    }

    @Override
    public String toString() {
        return "Allergy{" +
                "Id='" + id + '\'' +
                "Name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allergy allergy = (Allergy) o;
        return id.equals(allergy.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Allergy allergy) {
        return this.id.compareToIgnoreCase(allergy.id);
    }
}
