package com.djohannes.ac.za.controller.evaluation;

import com.djohannes.ac.za.domain.evaluation.Evaluation;
import com.djohannes.ac.za.service.impl.EvaluationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

    @Autowired
    private EvaluationServiceImpl service;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Evaluation create(@RequestBody Evaluation evaluation)
    {
        return service.create(evaluation);
    }

    @PutMapping("/update")
    @ResponseBody
    public Evaluation update(@RequestBody Evaluation evaluation) {
        return service.update(evaluation);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Evaluation read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping(value = "/getall", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Evaluation> getAll() {
        return service.getAll();
    }
}


