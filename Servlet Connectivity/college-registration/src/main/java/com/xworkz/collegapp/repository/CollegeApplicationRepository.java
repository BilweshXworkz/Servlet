package com.xworkz.collegapp.repository;

import com.xworkz.collegapp.entity.CollegeApplicationEntity;

import java.util.List;

public interface CollegeApplicationRepository {
    Boolean save (CollegeApplicationEntity collegeApplicationEntity);
    List<CollegeApplicationEntity> getCollegeApplicationDetails();
    void deleteById(int id);
}
