package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Meal;

public class MealFactory
{
    public static Meal getMeal(String meal)
    {
        return new Meal.Builder()
                .getmeal(meal)
                .build();
    }
}
