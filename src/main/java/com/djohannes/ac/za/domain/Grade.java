package com.djohannes.ac.za.domain;

public class Grade
{
    private int grade;

    private Grade()
    {}

    public int getGrade() {
        return grade;
    }

    public Grade(Builder builder)
    {
        this.grade=builder.grade;
    }

    public static class Builder
    {
        private int grade;

        public Builder getGrade(int grade)
        {
            this.grade=grade;
            return this;
        }

        public Grade build()
        {
            return new Grade(this);
        }
    }
}
