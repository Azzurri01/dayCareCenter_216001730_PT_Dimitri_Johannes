package com.djohannes.ac.za.factory;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import com.djohannes.ac.za.domain.Meal;

public class MealFactoryTest {

    @Test
    public void getMeal()
    {
        Meal meal = MealFactory.getMeal("Lunch");
        Assert.assertEquals("Lunch", meal.getMealType());
    }
}