package com.djohannes.ac.za.domain;
import java.util.Objects;

public class Clinic
{
    private String name, id;


    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Clinic(Builder builder)
    {
        this.id =builder.id;
        this.name =builder.name;
    }

    public static class Builder
    {
        private String id;
        private String name;

        public Builder getID(String id)
        {
            this.id =id;
            return this;
        }

        public Builder getName(String name)
        {
            this.name =name;
            return this;
        }

        public Clinic build()
        {
            return new Clinic(this);
        }
    }

    @Override
    public String toString() {
        return "Clinic{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clinic Clinic = (Clinic) o;
        return id.equals(Clinic.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}
