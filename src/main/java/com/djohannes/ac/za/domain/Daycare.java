package com.djohannes.ac.za.domain;
import java.util.Objects;
import java.util.Set;

public class Daycare
{
    private String id;
    private Name name;
    private Location location;
    private Contact contact;
    Set<Account> accounts;

    public String getId()
    {
        return id;
    }

    public Name getName()
    {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public Contact getContact() {
        return contact;
    }

    public Daycare(Builder builder)
    {
        this.id=builder.id;
        this.name=builder.name;
        this.location=builder.location;
        this.contact=builder.contact;
    }

    public static class Builder
    {
        private String id;
        private Name name;
        private Location location;
        private Contact contact;

        public Builder copy(Daycare daycare)
        {
            this.id=daycare.id;
            this.name=daycare.name;
            this.location=daycare.location;
            this.contact=daycare.contact;
            return this;
        }

        public Builder id(String id)
        {
            this.id=id;
            return this;
        }

        public String getId() {
            return id;
        }

        public Builder name(Name name)
        {
            this.name=name;
            return this;
        }

        public Builder location(Location location)
        {
            this.location=location;
            return this;
        }

        public Builder contact(Contact contact)
        {
            this.contact=contact;
            return this;
        }

        public Daycare build()
        {
            return new Daycare(this);
        }
    }

    @Override
    public String toString() {
        return "Daycare{" +
                "Name='" + name + '\'' +
                "ID='" + id + '\'' +
                "Location='" + location + '\'' +
                "Contact='" + contact + '\'' +
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
