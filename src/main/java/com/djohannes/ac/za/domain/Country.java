package com.djohannes.ac.za.domain;
import java.util.Objects;

public class Country
{
    private String name, code;


    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Country(Builder builder)
    {
        this.code=builder.code;
        this.name =builder.name;
    }

    public static class Builder
    {
        private String name, code;

        public Builder getCode(String code)
        {
            this.code=code;
            return this;
        }

        public Builder getName(String name)
        {
            this.name =name;
            return this;
        }

        public Country build()
        {
            return new Country(this);
        }
    }

    @Override
    public String toString() {
        return "Clinic{" +
                "code='" + code + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country= (Country) o;
        return code.equals(country.code);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(code);
    }
}
