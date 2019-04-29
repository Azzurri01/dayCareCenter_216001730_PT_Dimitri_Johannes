package com.djohannes.ac.za.domain;
import java.util.Objects;

public class Daycare
{
    private String name, id;


    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Daycare(Builder builder)
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
            this.name=name;
            return this;
        }

        public Daycare build()
        {
            return new Daycare(this);
        }
    }

    @Override
    public String toString() {
        return "Clinic{" +
                "name='" + name + '\'' +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Daycare daycare=(Daycare) o;
        return id.equals(daycare.id);
    }

    @Override
    public int hashCode()

    {
        return Objects.hash(id);
    }
}
