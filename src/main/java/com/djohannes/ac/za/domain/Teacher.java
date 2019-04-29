package com.djohannes.ac.za.domain;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "Teacher{" +
                "qualification='" + qualification + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher= (Teacher) o;
        return qualification.equals(teacher.qualification);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(qualification);
    }
}
