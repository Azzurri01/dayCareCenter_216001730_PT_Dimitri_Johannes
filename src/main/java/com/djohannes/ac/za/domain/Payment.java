package com.djohannes.ac.za.domain;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "Payment{" +
                "type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment= (Payment) o;
        return type.equals(payment.type);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(type);
    }
}
