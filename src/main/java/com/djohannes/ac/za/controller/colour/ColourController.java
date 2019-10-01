package com.djohannes.ac.za.controller.colour;


import com.djohannes.ac.za.domain.Colour;
import com.djohannes.ac.za.domain.user.ResponseObj;
import com.djohannes.ac.za.factory.ColourFactory;
import com.djohannes.ac.za.factory.ResponseObjFactory;
import com.djohannes.ac.za.service.impl.ColourServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/dccs/colour")
public class ColourController {

    @Autowired
    private ColourServiceImpl service;

    @PostMapping(value = "/create/{colour}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createEmployee(@PathVariable String colour)
    {
        System.out.println("Entered Value: " + colour);
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Colour created!");
        Colour savedColour;
        if (colour == null || colour.trim().isEmpty() || colour.trim().equalsIgnoreCase("null")) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide a colour!");
        } else {
            savedColour = service.read(colour);
            if (savedColour != null) {
                responseObj.setResponseDescription("Colour already exist!");
            } else {
                savedColour = ColourFactory.getColour(colour);
                savedColour = service.create(savedColour);
            }
            responseObj.setResponse(savedColour);
        }
        return ResponseEntity.ok(responseObj);
    }

    @PostMapping("/update")
    @ResponseBody
    public Colour update(Colour colour) {
        return service.update(colour);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Colour read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping(value = "/getall", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll() {
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        List<Colour> colours = service.getAll();
        responseObj.setResponse(colours);
        return ResponseEntity.ok(responseObj);
    }
}
