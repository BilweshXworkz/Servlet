package com.xworkz.collegapp.dto;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

@Data
public class CollegeApplicationDto {
    private Integer id;
    private String firstName;
    private String  lastName;
    private Long phoneNumber;
    private String emailId;
    private String education;
}
