package com.example.mapStruct.mapper;

import com.example.mapStruct.dto.StudentDTO;
import com.example.mapStruct.model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student map(StudentDTO studentDTO);

    StudentDTO map(Student student);
}
