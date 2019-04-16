package com.djohannes.ac.za.domain;

public class Activity
{
    private int aID;
    private String aName;


    public int getID() {
        return aID;
    }

    public String getName() {
        return aName;
    }

    public Activity(Builder builder)
    {
        this.aID=builder.bID;
        this.aName =builder.bName;
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

        public Activity build()
        {
            return new Activity(this);
        }
    }
}
