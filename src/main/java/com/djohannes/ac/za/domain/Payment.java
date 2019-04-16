package com.djohannes.ac.za.domain;

public class Payment
{
    private String type;

    private Payment()
    {

    }

    public String getType() {
        return type;
    }

    public Payment(Builder builder)
    {
        this.type=builder.type;
    }

    public static class Builder
    {
        private String type;

        public Builder getPaymentMethod(String type)
        {
            this.type=type;
            return this;
        }

        public Payment build()
        {
            return new Payment(this);
        }
    }
}
