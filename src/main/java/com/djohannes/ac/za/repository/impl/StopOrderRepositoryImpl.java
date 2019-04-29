package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.StopOrder;
import com.djohannes.ac.za.repository.StopOrderRepository;

import java.util.HashSet;
import java.util.Set;

public class StopOrderRepositoryImpl implements StopOrderRepository {

    private static StopOrderRepositoryImpl repository = null;
    private Set<StopOrder> stoporders;

    private StopOrderRepositoryImpl() {
        this.stoporders = new HashSet<>();
    }

    public static StopOrderRepository getRepository(){
        if(repository == null) repository = new StopOrderRepositoryImpl();
        return repository;
    }

    public StopOrder create(StopOrder stoporder){
        this.stoporders.add(stoporder);
        return stoporder;
    }

    public StopOrder read(String stoporderId){
        //find the student in the set and return it if it exist
        return null;
    }

    public StopOrder update(StopOrder stoporder) {
        // find the student, update it and return the updated student
        return null;
    }

    public void delete(String stoporderId) {
        //find the student and delete it if it exists

    }

    public Set<StopOrder> getAll(){
        return this.stoporders;
    }
}