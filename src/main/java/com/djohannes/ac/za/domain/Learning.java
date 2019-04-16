package com.djohannes.ac.za.domain;

public class Learning
{

    private String type;
    private int stuNo;

    private Learning()
    {}

    public String getType() {
        return type;
    }

    public int getStuNo() {
        return stuNo;
    }

    public Learning(Builder builder)
    {
        this.type=builder.type;
        this.stuNo=builder.stuNo;
    }

    public static class Builder
    {
        private String type;
        private int stuNo;

        public Builder getType(String type)
        {
            this.type=type;
            return this;
        }

        public Builder getStudent(int stu)
        {
            this.stuNo=stu;
            return this;
        }

        public Learning build()
        {
            return new Learning(this);
        }
    }
}
