package com.djohannes.ac.za.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class IndexController {
    @RequestMapping(value = {"/", "home"})
    public ResponseEntity<String> home() {
        return new ResponseEntity<>("<h1>Home Screen</h1>", HttpStatus.OK);
    }
}