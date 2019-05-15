package com.djohannes.ac.za.domain;
import java.util.Objects;
import java.util.Set;

public class Grade
{
    private String id, grade;
    Set<Student> student;

    private Grade()
    {}

    public String getId() {
        return id;
    }

    public String getGrade() {
        return grade;
    }

    public Grade(Builder builder)
    {
        this.id=builder.id;
        this.grade=builder.grade;
    }

    public static class Builder
    {
        private String id, grade;

        public Builder copy(Grade grade)
        {
            this.id=grade.id;
            this.grade=grade.grade;
            return this;
        }

        public Builder id(String id)
        {
            this.id=id;
            return this;
        }

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
