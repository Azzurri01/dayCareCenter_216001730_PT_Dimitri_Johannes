package com.djohannes.ac.za.domain;

import java.util.Objects;

public class Activity
{
    private String id;
    private Grade grade;
    private Alphabet alphabet;
    private Counting counting;
    private Colour colour;
    private Drawing drawing;
    private  Playtime playtime;

    public Activity() {
    }

    public Activity(Builder builder)
    {
        this.id=builder.id;
        this.grade=builder.grade;
        this.alphabet=builder.alphabet;
        this.counting=builder.counting;
        this.colour=builder.colour;
        this.drawing=builder.drawing;
        this.playtime=builder.playtime;
    }

    public String getId() {
        return id;
    }

    public Grade getGrade() {
        return grade;
    }

    public Alphabet getAlphabet() {
        return alphabet;
    }

    public Counting getCounting() {
        return counting;
    }

    public Colour getColour() {
        return colour;
    }

    public Drawing getDrawing() {
        return drawing;
    }

    public Playtime getPlaytime() {
        return playtime;
    }

    public static class Builder
    {
        private String id;
        private Grade grade;
        private Alphabet alphabet;
        private Counting counting;
        private Colour colour;
        private Drawing drawing;
        private  Playtime playtime;

        public Builder id(String id)
        {
            this.id =id;
            return this;
        }

        public Builder grade(Grade grade)
        {
        this.grade=grade;
        return this;
        }

        public Builder alphabet(Alphabet alphabet)
        {
            this.alphabet=alphabet;
            return this;
        }

        public Builder counting(Counting counting)
        {
            this.counting=counting;
            return this;
        }

        public Builder colour(Colour colour)
        {
            this.colour=colour;
            return this;
        }

        public Builder drawing(Drawing drawing)
        {
            this.drawing=drawing;
            return this;
        }

        public Builder playtime(Playtime playtime)
        {
            this.playtime=playtime;
            return this;
        }

        public Activity build()
        {
            return new Activity(this);
        }
    }

    @Override
    public String toString() {
        return "Activity{" +
                "ID='" + id + '\'' +
                ", Grade='" + grade + '\'' +
                ", Alphabet='" + alphabet + '\'' +
                ", Counting='" + counting + '\'' +
                ", Colour='" + colour + '\'' +
                ", Drawing='" + drawing + '\'' +
                ", Playtime='" + playtime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return id.equals(activity.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}
