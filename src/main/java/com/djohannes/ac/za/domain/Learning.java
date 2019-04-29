package com.djohannes.ac.za.domain;
import java.util.Objects;

public class Learning
{

    private String type, stuNo;

    private Learning()
    {}

    public String getType() {
        return type;
    }

    public String getStuNo() {
        return stuNo;
    }

    public Learning(Builder builder)
    {
        this.type=builder.type;
        this.stuNo=builder.stuNo;
    }

    public static class Builder
    {
        private String type, stuNo;

        public Builder getType(String type)
        {
            this.type=type;
            return this;
        }

        public Builder getStudent(String stu)
        {
            this.stuNo=stu;
            return this;
        }

        public Learning build()
        {
            return new Learning(this);
        }
    }

    @Override
    public String toString() {
        return "Learning{" +
                "type='" + type + '\'' +
                "stuNo='" + stuNo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
       Learning learning=(Learning) o;
        return stuNo.equals(learning.stuNo);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(stuNo);
    }
}
