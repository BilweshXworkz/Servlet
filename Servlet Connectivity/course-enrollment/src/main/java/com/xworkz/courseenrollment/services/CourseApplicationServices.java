package com.xworkz.courseenrollment.services;

import com.xworkz.courseenrollment.dto.CourseApplicationDto;

import java.util.List;

public interface CourseApplicationServices {
    Boolean ValidAndSave(CourseApplicationDto dto);
    List<CourseApplicationDto> getCourse();
    void deleteById(int id);
}
