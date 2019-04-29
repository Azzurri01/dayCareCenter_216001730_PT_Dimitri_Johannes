package com.djohannes.ac.za.domain;
import java.util.Objects;

public class Street
{
    private String name, no;


    public String getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public Street(Builder builder)
    {
        this.no=builder.no;
        this.name =builder.name;
    }

    public static class Builder
    {
        private String name, no;

        public Builder getID(String no)
        {
            this.no=no;
            return this;
        }

        public Builder getName(String name)
        {
            this.name =name;
            return this;
        }

        public Street build()
        {
            return new Street(this);
        }
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                "no='" + no + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Street street= (Street) o;
        return no.equals(street.no);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(no);
    }
}
