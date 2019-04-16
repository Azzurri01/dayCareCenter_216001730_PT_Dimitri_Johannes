package com.djohannes.ac.za.domain;

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
}
