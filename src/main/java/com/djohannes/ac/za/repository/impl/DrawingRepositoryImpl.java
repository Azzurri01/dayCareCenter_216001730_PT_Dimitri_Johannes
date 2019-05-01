package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Drawing;
import com.djohannes.ac.za.repository.DrawingRepository;

import java.util.HashSet;
import java.util.Set;

public class DrawingRepositoryImpl implements DrawingRepository {

    private static DrawingRepositoryImpl repository = null;
    private Set<Drawing> shapes;

    private DrawingRepositoryImpl() {
        this.shapes = new HashSet<>();
    }

    private Drawing findDrawing(String shapeId) {
        /*return this.shapes.stream()
                .filter(shape -> shape.getNo().trim().equals(shapeId))
                .findAny()
                .orElse(null);*/
        return null;
    }

    public static DrawingRepositoryImpl getRepository(){
        if(repository == null) repository = new DrawingRepositoryImpl();
        return repository;
    }

    public Drawing create(Drawing shape){
        this.shapes.add(shape);
        return shape;
    }

    public Drawing read(final String shapeId){
        //find the student in the set and return it if it exist
        Drawing shape = findDrawing(shapeId);
        return shape;
    }

    public Drawing update(Drawing shape) {
        // find the student, update it and return the updated student
        Drawing toDelete = findDrawing(shape.getShapes());
        if(toDelete != null) {
            this.shapes.remove(toDelete);
            return create(shape);
        }
        return null;
    }

    public void delete(String shapeId) {
        //find the student and delete it if it exists
        Drawing shape = findDrawing(shapeId);
        if (shape != null) this.shapes.remove(shape);
    }

    public Set<Drawing> getAll(){
        return this.shapes;
    }
}