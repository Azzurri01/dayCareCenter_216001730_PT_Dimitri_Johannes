package com.djohannes.ac.za.domain;
import java.util.Objects;

public class Suburb
{
    private String name, id;
    

    public String getID()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public Suburb(Builder builder)
    {
        this.id=builder.id;
        this.name =builder.name;
    }

    public static class Builder
    {
        private String name, id;

        public Builder getID(String id)
        {
            this.id=id;
            return this;
        }

        public Builder getName(String name)
        {
            this.name =name;
            return this;
        }

        public Suburb build()
        {
            return new Suburb(this);
        }
    }

    @Override
    public String toString() {
        return "Suburb{" +
                "name='" + name + '\'' +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Suburb suburb=(Suburb) o;
        return id.equals(suburb.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}
