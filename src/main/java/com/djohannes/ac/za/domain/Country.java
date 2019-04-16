package com.djohannes.ac.za.domain;

public class Country
{
    private int cID;
    private String cName;


    public int getID() {
        return cID;
    }

    public String getName() {
        return cName;
    }

    public Country(Builder builder)
    {
        this.cID=builder.bID;
        this.cName =builder.bName;
    }

    public static class Builder
    {
        private int bID;
        private String bName;

        public Builder getID(int id)
        {
            this.bID=id;
            return this;
        }

        public Builder getName(String name)
        {
            this.bName =name;
            return this;
        }

        public Country build()
        {
            return new Country(this);
        }
    }
}
