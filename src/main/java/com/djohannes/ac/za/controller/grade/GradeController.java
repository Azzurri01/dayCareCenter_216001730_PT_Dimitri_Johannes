package com.djohannes.ac.za.controller.grade;


import com.djohannes.ac.za.domain.Grade;
import com.djohannes.ac.za.domain.user.ResponseObj;
import com.djohannes.ac.za.factory.GradeFactory;
import com.djohannes.ac.za.factory.ResponseObjFactory;
import com.djohannes.ac.za.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/dccs/grade")
public class GradeController {
    @Autowired
    @Qualifier("GradeServiceImpl")
    private GradeService service;

    @PostMapping(value = "/create/{grade}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity createGrade(@PathVariable String grade) {
        System.out.println("Entered Value: " + grade);
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Grade created!");
        Grade savedGrade;
        if (grade == null || grade.trim().isEmpty() || grade.trim().equalsIgnoreCase("null")) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide a grade!");
        } else {
            savedGrade = service.read(grade);
            if (savedGrade != null) {
                responseObj.setResponseDescription("Grade already exist!");
            } else {
                savedGrade = GradeFactory.getGrade(grade);
                savedGrade = service.create(savedGrade);
            }
            responseObj.setResponse(savedGrade);
        }
        return ResponseEntity.ok(responseObj);
    }

    @PostMapping("/update")
    @ResponseBody
    public Grade update(Grade grade) {
        return service.update(grade);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Grade read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<Grade> getAll() {
        return service.getAll();
    }
}
