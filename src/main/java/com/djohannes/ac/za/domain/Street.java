package com.djohannes.ac.za.domain;

public class Street
{
    private int no;
    private String aName;


    public int getID() {
        return no;
    }

    public String getName() {
        return aName;
    }

    public Street(Builder builder)
    {
        this.no=builder.no;
        this.aName =builder.bName;
    }

    public static class Builder
    {
        private int no;
        private String bName;

        public Builder getID(int nr)
        {
            this.no=nr;
            return this;
        }

        public Builder getName(String name)
        {
            this.bName =name;
            return this;
        }

        public Street build()
        {
            return new Street(this);
        }
    }
}
