package com.djohannes.ac.za.controller.alphabet;


import com.djohannes.ac.za.domain.Alphabet;
import com.djohannes.ac.za.service.AlphabetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/alphabet")
public class AlphabetController {
    @Autowired
    @Qualifier("AlphabetServiceImpl")
    private AlphabetService service;

    @PostMapping("/create")
    @ResponseBody
    public Alphabet create(Alphabet alphabet) {
        return service.create(alphabet);
    }

    @PostMapping("/update")
    @ResponseBody
    public Alphabet update(Alphabet alphabet) {
        return service.update(alphabet);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Alphabet read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Alphabet> getAll() {
        return service.getAll();
    }
}
