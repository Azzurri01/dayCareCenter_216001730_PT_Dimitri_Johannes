package com.djohannes.ac.za.domain;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "StopOrder{" +
                "date='" + date + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StopOrder stopOrder= (StopOrder) o;
        return date.equals(stopOrder.date);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(date);
    }
}
