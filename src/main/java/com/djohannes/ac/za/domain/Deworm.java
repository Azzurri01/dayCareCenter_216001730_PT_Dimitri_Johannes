package com.djohannes.ac.za.domain;
import java.util.Objects;

public class Deworm
{
    private String injection, id;

    private Deworm()
    {

    }

    public String getDeworming()
    {
        return injection;
    }

    public String getId() {
        return id;
    }

    public Deworm(Builder builder)
    {
        this.injection =builder.injection;
        this.id=builder.id;
    }

    public static class Builder
    {
        private String injection, id;

        public Builder getInjection(String injection)
    {
        this.injection =injection;
        return this;
    }

        public Builder getID(String id)
        {
            this.id =id;
            return this;
        }

        public Deworm build()
        {
            return new Deworm(this);
        }
    }

    @Override
    public String toString() {
        return "Clinic{" +
                "injection='" + injection + '\'' +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deworm deworm= (Deworm) o;
        return id.equals(deworm.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}
