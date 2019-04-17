package com.djohannes.ac.za.domain;

public class Teacher
{
    private String qualification;

    private Teacher()
    {

    }

    public String getQualification() {
        return qualification;
    }

    public Teacher(Builder builder)
    {
        this.qualification =builder.qualification;
    }

    public static class Builder
    {
        private String qualification;


        public Builder getQual(String qualification)
        {
            this.qualification =qualification;
            return this;
        }

        public Teacher build()
        {
            return new Teacher(this);
        }
    }
}
