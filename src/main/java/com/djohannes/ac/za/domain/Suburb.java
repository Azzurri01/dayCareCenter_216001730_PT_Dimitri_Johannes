package com.djohannes.ac.za.domain;

public class Suburb
{
    private int sID;
    private String sName;
    

    public int getID() {
        return sID;
    }

    public String getName()
    {
        return sName;
    }

    public Suburb(Builder builder)
    {
        this.sID=builder.bID;
        this.sName =builder.bName;
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

        public Suburb build()
        {
            return new Suburb(this);
        }
    }
}
