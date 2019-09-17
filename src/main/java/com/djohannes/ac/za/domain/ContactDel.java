package com.djohannes.ac.za.domain;

import java.util.Objects;

public class ContactDel {
    private String id, tel, email;

    private ContactDel() {
    }

    private ContactDel(Builder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.tel = builder.tel;
    }

    public String getId() {
        return id;
    }


    public String getContactNo() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public static class Builder {
        private String id, tel, email;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder contactNo(String tel) {
            this.tel = tel;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder copy(ContactDel contact) {
            this.id = contact.id;
            this.tel = contact.tel;
            this.email = contact.email;
            return this;
        }

        public ContactDel build() {
            return new ContactDel(this);
        }
    }

    @Override
    public String toString() {
        return "Contact{" +
                "Id='" + id + '\'' +
                "Email='" + email + '\'' +
                "Telephone='" + tel + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactDel contact = (ContactDel) o;
        return id.equals(contact.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}