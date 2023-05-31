package com.example.dto.service;

import com.example.dto.dto.request.SchoolCreateDTO;
import com.example.dto.dto.request.SchoolUpdateDTO;
import com.example.dto.models.School;
import com.example.dto.repository.SchoolRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    ModelMapper mapper = new ModelMapper();

    @Autowired
    SchoolRepository schoolRepository;

    public List<School> getAllSchool(){
        List<School> list;
        list = schoolRepository.findAll();
        return list;
    }

    public School getSchoolById(Long id){
        Optional<School> foundSchool = schoolRepository.findById(id);
        if (foundSchool.isPresent()){
            return foundSchool.get();
        }else {
            return null;
        }
    }

    public School createSchool(SchoolCreateDTO createSchool){
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        School school = mapper.map(createSchool, School.class);
        return schoolRepository.save(school);
    }

    public School updateSchool(SchoolUpdateDTO updateDTO){
        Optional<School> foundSchool = schoolRepository.findById(updateDTO.getId());
        if (foundSchool.isPresent()){
            School school = foundSchool.get();
            school.setSchoolLevel(updateDTO.getSchoolLevel());
            return schoolRepository.save(school);
        }else{
            return null;
        }
    }

    public String deleteSchool(Long id){
        Optional<School> foundSchool = schoolRepository.findById(id);
        if (foundSchool.isPresent()){
            schoolRepository.deleteById(id);
            return "Silme başarılı";
        }else
            return "Silme başarısız";
    }
}
