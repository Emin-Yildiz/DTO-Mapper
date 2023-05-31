package com.example.mapStruct.model;

import lombok.*;

@Data
public class Student {
    private long id;
    private long tcNumber;
    private String nameSurname;
    private int age;
    private String schoolName;
    private String country;
    private String city;
    private String schoolScore;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTcNumber() {
        return tcNumber;
    }

    public void setTcNumber(long tcNumber) {
        this.tcNumber = tcNumber;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSchoolScore() {
        return schoolScore;
    }

    public void setSchoolScore(String schoolScore) {
        this.schoolScore = schoolScore;
    }

    public Student(long id, long tcNumber, String nameSurname, int age, String schoolName, String country, String city, String schoolScore) {
        this.id = id;
        this.tcNumber = tcNumber;
        this.nameSurname = nameSurname;
        this.age = age;
        this.schoolName = schoolName;
        this.country = country;
        this.city = city;
        this.schoolScore = schoolScore;
    }

    public Student(){}
}
