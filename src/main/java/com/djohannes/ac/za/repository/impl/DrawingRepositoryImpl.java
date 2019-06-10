package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Drawing;
import com.djohannes.ac.za.repository.DrawingRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("DrawingMemory")
public class DrawingRepositoryImpl implements DrawingRepository {

    private static DrawingRepositoryImpl repository = null;
    private Set<Drawing> drawings;

    private DrawingRepositoryImpl() {
        this.drawings = new HashSet<>();
    }

    private Drawing findDrawing(String drawingId) {
        return this.drawings.stream()
                .filter(drawing -> drawing.getId().trim().equals(drawingId))
                .findAny()
                .orElse(null);
    }

    public static DrawingRepositoryImpl getRepository(){
        if(repository == null) repository = new DrawingRepositoryImpl();
        return repository;
    }

    public Drawing create(Drawing drawing){
        this.drawings.add(drawing);
        return drawing;
    }

    public Drawing read(final String drawingId){
        //find the student in the set and return it if it exist
        Drawing drawing = findDrawing(drawingId);
        return drawing;
    }

    public Drawing update(Drawing drawing) {
        // find the student, update it and return the updated student
        Drawing toDelete = findDrawing(drawing.getId());
        if(toDelete != null) {
            this.drawings.remove(toDelete);
            return create(drawing);
        }
        return null;
    }

    public void delete(String drawingId) {
        //find the student and delete it if it exists
        Drawing drawing = findDrawing(drawingId);
        if (drawing != null) this.drawings.remove(drawing);
    }

    public Set<Drawing> getAll(){
        return this.drawings;
    }
}