package com.example.dto.controller;

import com.example.dto.dto.request.SchoolCreateDTO;
import com.example.dto.dto.request.SchoolUpdateDTO;
import com.example.dto.models.School;
import com.example.dto.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    SchoolService schoolService;

    @GetMapping
    public List<School> getAllSchool(){
        return schoolService.getAllSchool();
    }

    @GetMapping("/{id}")
    public School getSchoolById(@PathVariable Long id){
        return schoolService.getSchoolById(id);
    }

    @PostMapping()
    public School createSchool(@RequestBody SchoolCreateDTO createDTO){
        return schoolService.createSchool(createDTO);
    }

    @PutMapping
    public School updateSchool(@RequestBody SchoolUpdateDTO updateDTO){
        return schoolService.updateSchool(updateDTO);
    }

    @DeleteMapping("/{id}")
    public String  deleteSchool(@PathVariable Long id){
        return schoolService.deleteSchool(id);
    }
}
