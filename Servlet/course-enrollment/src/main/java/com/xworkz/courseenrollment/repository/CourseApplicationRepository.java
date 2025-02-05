package com.xworkz.courseenrollment.repository;

import com.xworkz.courseenrollment.entity.CourseApplicationEntity;

import java.util.List;

public interface CourseApplicationRepository {
    Boolean save (CourseApplicationEntity courseApplicationEntity);
    List<CourseApplicationEntity> getApplicationDetails();
    void deleteById(int id);
    CourseApplicationEntity getCourseById(int id);
    void updateCourse(CourseApplicationEntity entity);
}
