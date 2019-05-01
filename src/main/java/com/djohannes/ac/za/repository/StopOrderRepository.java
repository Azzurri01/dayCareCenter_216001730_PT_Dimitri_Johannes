package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.StopOrder;

import java.util.Set;

public interface StopOrderRepository extends IRepository<StopOrder, String>
{
    Set<StopOrder> getAll();
}