package com.djohannes.ac.za.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@EntityScan
public class Counting implements Comparable<Counting>
{
    @Id
    private String id;
    private int number;

    private Counting() {
    }

    private Counting(Builder builder)
    {
        this.id=builder.id;
        this.number =builder.number;
    }

    public String getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public static class Builder
    {
        private String id;
        private int number;

        public Builder copy(Counting counting)
        {
            this.id=counting.id;
            this.number=counting.number;
            return this;
        }

        public Builder id(String id)
        {
            this.id=id;
            return this;
        }

        public Builder number(int number)
        {
            this.number=number;
            return this;
        }

        public Counting build()
        {
            return new Counting(this);
        }
    }

    @Override
    public String toString() {
        return "Counting{" +
                "Id='" + id + '\'' +
                "Number='" + number + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Counting counting = (Counting) o;
        return id.equals(counting.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Counting counting) {
        return this.id.compareToIgnoreCase(counting.id);
    }
}
