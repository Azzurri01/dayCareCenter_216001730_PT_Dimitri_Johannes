package com.djohannes.ac.za.domain;

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

}
