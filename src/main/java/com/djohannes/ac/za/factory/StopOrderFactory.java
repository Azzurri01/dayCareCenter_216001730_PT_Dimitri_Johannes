package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.StopOrder;

public class StopOrderFactory
{
    public static StopOrder getStopOrderDate(String date)
    {
        return new StopOrder.Builder()
                .getStopOrderDate(date)
                .build();
    }
}
