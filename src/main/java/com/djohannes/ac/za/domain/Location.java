package com.djohannes.ac.za.domain;
import java.util.Objects;

public class Location
{
    private String type, id;

    public String getID() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Location(Builder builder)
    {
        this.id=builder.type;
        this.type =builder.type;
    }

    public static class Builder
    {
        private String type, id;

        public Builder getlID(String id)
        {
            this.id =id;
            return this;
        }

        public Builder getType(String type)
        {
            this.type =type;
            return this;
        }

        public Location build()
        {
            return new Location(this);
        }
    }

    @Override
    public String toString() {
        return "Location{" +
                "type='" + type + '\'' +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location= (Location) o;
        return id.equals(location.id);
    }

    @Override
    public int hashCode()
            
    {
        return Objects.hash(id);
    }
}
