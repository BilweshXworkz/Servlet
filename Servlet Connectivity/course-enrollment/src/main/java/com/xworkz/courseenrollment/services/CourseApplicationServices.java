package com.xworkz.courseenrollment.services;

import com.xworkz.courseenrollment.dto.CourseApplicationDto;

public interface CourseApplicationServices {
    Boolean ValidAndSave(CourseApplicationDto dto);
}
