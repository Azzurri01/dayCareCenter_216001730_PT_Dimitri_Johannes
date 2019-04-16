package com.djohannes.ac.za.domain;

public class Meal
{
    private String mealType;

    private Meal()
    {}

    public String getMealType() {
        return mealType;
    }

    public Meal(Builder builder)
    {
        this.mealType=builder.mealType;
    }

    public static class Builder
    {
        private String mealType;

        public Builder getmeal(String meal)
        {
            this.mealType=meal;
            return this;
        }

        public Meal build()
        {
            return new Meal(this);
        }
    }

}
