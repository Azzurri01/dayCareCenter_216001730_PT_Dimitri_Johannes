package com.djohannes.ac.za.domain;

public class Location
{
    private int lID;
    private String lType;

    public int getlID() {
        return lID;
    }

    public String getlType() {
        return lType;
    }

    public Location(Builder builder)
    {
        this.lID=builder.bID;
        this.lType=builder.bType;
    }

    public static class Builder
    {
        private int bID;
        private String bType;

        public Builder getlID(int id)
        {
            this.bID=id;
            return this;
        }

        public Builder getType(String type)
        {
            this.bType=type;
            return this;
        }

        public Location build()
        {
            return new Location(this);
        }
    }
}
