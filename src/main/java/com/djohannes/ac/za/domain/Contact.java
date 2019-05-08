package com.djohannes.ac.za.domain;

public class Contact {
    private String id,telefone, email;

    private Contact()
    {}

    private Contact(Builder builder)
    {
        this.id=builder.id;
        this.telefone=builder.telefone;
        this.email=builder.email;
    }

    public String getId() {
        return id;
    }

    public String getContactNo() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public static class Builder
    {
        private String id, telefone, email;

        public Builder id(String id)
        {
            this.id=id;
            return this;
        }

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

        public Builder copy(Contact contact)
        {
            this.id=contact.id;
            this.telefone=contact.telefone;
            this.email=contact.email;
            return this;
        }

        public Contact build()
        {
            return new Contact(this);
        }
    }
}
