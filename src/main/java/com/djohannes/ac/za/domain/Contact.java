package com.djohannes.ac.za.domain;

public class Contact {
    private String telefone, email;

    private Contact()
    {}

    private Contact(Builder builder)
    {
        this.telefone=builder.telefone;
        this.email=builder.email;
    }

    public String getContactNo() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public static class Builder
    {
        private String telefone, email;

        public Builder contactNo(String telefone)
        {
            this.telefone=telefone;
            return this;
        }

        public Builder email(String email)
        {
            this.email=email;
            return this;
        }

        public Contact build()
        {
            return new Contact(this);
        }
    }
}
