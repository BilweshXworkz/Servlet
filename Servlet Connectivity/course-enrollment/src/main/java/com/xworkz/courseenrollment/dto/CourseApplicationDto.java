package com.xworkz.courseenrollment.dto;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

@Data
public class CourseApplicationDto {
    private Integer id;
    private String firstName;
    private String  lastName;
    private Long phoneNumber;
    private String emailId;
    private String education;
}
