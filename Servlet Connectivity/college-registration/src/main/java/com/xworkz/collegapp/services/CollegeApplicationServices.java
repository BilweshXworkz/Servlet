package com.xworkz.collegapp.services;

import com.xworkz.collegapp.dto.CollegeApplicationDto;

import java.util.List;

public interface CollegeApplicationServices {
    Boolean ValidAndSave(CollegeApplicationDto dto);
    List<CollegeApplicationDto> getApplication();
    void deleteById(int id);
}
