package com.djohannes.ac.za.domain;
import java.util.Objects;

public class Play
{
    private String time;

    private Play()
    {}

    public String getPlayTime() {
        return time;
    }

    public Play(Builder builder)
    {
        this.time=builder.time;
    }

    public static class Builder
    {
        private String time;

        public Builder getPlayTime(String time)
        {
            this.time=time;
            return this;
        }

        public Play build()
        {
            return new Play(this);
        }
    }

    @Override
    public String toString() {
        return "Play{" +
                "time='" + time + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Play play= (Play) o;
        return time.equals(play.time);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(time);
    }
}
