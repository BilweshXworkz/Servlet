package com.xworkz.courseenrollment.dto;

import lombok.Data;

@Data
public class CourseApplicationDto {
    private String firstName;
    private String  lastName;
    private Long phoneNumber;
    private String emailId;
    private String education;
}
