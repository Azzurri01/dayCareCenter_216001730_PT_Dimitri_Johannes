package com.djohannes.ac.za.domain;

public class Daycare
{
    private int dID;
    private String dName;


    public int getID() {
        return dID;
    }

    public String getName() {
        return dName;
    }

    public Daycare(Builder builder)
    {
        this.dID=builder.bID;
        this.dName =builder.bName;
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

        public Daycare build()
        {
            return new Daycare(this);
        }
    }
}
