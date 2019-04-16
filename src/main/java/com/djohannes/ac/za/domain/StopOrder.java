package com.djohannes.ac.za.domain;

public class StopOrder
{
    private String date;

    private StopOrder()
    {

    }

    public String getDate() {
        return date;
    }

    public StopOrder(Builder builder)
    {
        this.date=builder.date;
    }

    public static class Builder
    {
        private String date;

        public Builder getStopOrderDate(String date)
        {
            this.date=date;
            return this;
        }

        public StopOrder build()
        {
            return new StopOrder(this);
        }
    }
}
