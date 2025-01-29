package com.xworkz.collegapp.services;

import com.xworkz.collegapp.dto.CollegeApplicationDto;

public interface CollegeApplicationServices {
    Boolean ValidAndSave(CollegeApplicationDto dto);
}
