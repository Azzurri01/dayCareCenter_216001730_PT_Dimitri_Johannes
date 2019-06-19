package com.djohannes.ac.za.controller.evaluation;


import com.djohannes.ac.za.domain.Evaluation;
import com.djohannes.ac.za.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {
    @Autowired
    @Qualifier("EvaluationServiceImpl")
    private EvaluationService service;

    @PostMapping("/create")
    @ResponseBody
    public Evaluation create(@RequestBody Evaluation evaluation) {
        return service.create(evaluation);
    }

    @PostMapping("/update")
    @ResponseBody
    public Evaluation update(Evaluation evaluation) {
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

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Evaluation> getAll() {
        return service.getAll();
    }
}
