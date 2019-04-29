package com.djohannes.ac.za.domain;
import java.util.Objects;

public class Excursion
{
    private String date, venue;

    private Excursion()
    {}

    public String getDate() {
        return date;
    }

    public String getVenue() {
        return venue;
    }

    public Excursion(Builder builder)
    {
        this.date=builder.date;
        this.venue=builder.venue;
    }

    public static class Builder
    {
        private String date, venue;

        public Builder getDate(String date)
        {
            this.date=date;
            return this;
        }

        public Builder getVenue(String venue)
        {
            this.venue=venue;
            return this;
        }

        public Excursion build()
        {
            return new Excursion(this);
        }
    }

    @Override
    public String toString() {
        return "Clinic{" +
                "date='" + date + '\'' +
                "venue='" + venue + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Excursion excursion=(Excursion) o;
        return date.equals(excursion.date);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(date);
    }
}
