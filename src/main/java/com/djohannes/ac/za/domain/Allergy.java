package com.djohannes.ac.za.domain;

import java.util.Objects;

public class Allergy
{
    private String name, code;

    private Allergy()
    {
    }

    public Allergy(Builder builder)
    {
        this.name=builder.name;;
        this.code=builder.code;
    }

    public String getName()
    {
        return name;
    }

    public String getCode()
    {
        return code;
    }

    public static class Builder
    {
        private String name, code;

        public Builder getName(String name)
        {
            this.name=name;
            return this;
        }

        public Builder getCode(String code)
        {
            this.code=code;
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
                ", Code='" + code + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allergy allergy = (Allergy) o;
        return code.equals(allergy.code);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(code);
    }
}
