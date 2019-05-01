package com.djohannes.ac.za.domain;
import java.util.Objects;

public class Grade
{
    private String grade;

    private Grade()
    {}

    public String getGrade() {
        return grade;
    }

    public Grade(Builder builder)
    {
        this.grade=builder.grade;
    }

    public static class Builder
    {
        private String grade;

        public Builder getGrade(String grade)
        {
            this.grade=grade;
            return this;
        }

        public Grade build()
        {
            return new Grade(this);
        }
    }

    @Override
    public String toString() {
        return "Grade{" +
                "grade='" + grade + '\'' +
                '}';
    }
}
