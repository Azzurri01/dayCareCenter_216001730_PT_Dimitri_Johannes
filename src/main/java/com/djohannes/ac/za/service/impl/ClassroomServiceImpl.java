package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Classroom;
import com.djohannes.ac.za.repository.ClassroomRepository;
import com.djohannes.ac.za.service.ClassroomService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ClassroomServiceImpl")
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    //@Qualifier("ClassroomMemory")
    private ClassroomRepository repository;

    @Override
    public Classroom create(Classroom classroom) {
        return this.repository.save(classroom);
    }

    @Override
    public Classroom update(Classroom classroom) {
        return this.repository.save(classroom);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Classroom read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public List<Classroom> getAll() {
        return this.repository.findAll();
    }
}