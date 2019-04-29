package com.djohannes.ac.za.domain;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "Meal{" +
                "mealType='" + mealType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal= (Meal) o;
        return mealType.equals(meal.mealType);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(mealType);
    }
}
