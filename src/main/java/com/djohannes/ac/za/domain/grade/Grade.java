package com.djohannes.ac.za.domain.grade;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Grade implements Comparable<Grade>
{
    @Id
    private String id;
    private String grade;

    private Grade()
    {}

    private Grade(Builder builder)
    {
        this.id=builder.id;
        this.grade=builder.grade;
    }

    public String getId() {
        return id;
    }

    public String getGrade() {
        return grade;
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
                "Id='" + id + '\'' +
                "grade='" + grade + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return id.equals(grade.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Grade grade) {
        return this.id.compareToIgnoreCase(grade.id);
    }
}


