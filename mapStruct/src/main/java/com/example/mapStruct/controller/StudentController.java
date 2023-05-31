package com.example.mapStruct.controller;

import com.example.mapStruct.dto.StudentDTO;
import com.example.mapStruct.mapper.StudentMapper;
import com.example.mapStruct.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class StudentController {

    private final StudentMapper studentMapper;

    public StudentController(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @GetMapping
    public ResponseEntity getStudent (){

        Student student = new Student();

        student.setAge(18);
        student.setCity("Sivas");
        student.setTcNumber(12345678910L);
        student.setSchoolScore("3.27");
        student.setNameSurname("emin yıldız");
        student.setId(1);
        student.setSchoolName("cü");
        student.setCountry("Türkiye");

        StudentDTO studentDto = studentMapper.map(student);

        return ResponseEntity.ok(studentDto);
    }

}
