package com.djohannes.ac.za.domain;

import java.util.Objects;

public class Allergy
{
    private String name, id;

    private Allergy()
    {
    }

    public Allergy(Builder builder)
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
}
