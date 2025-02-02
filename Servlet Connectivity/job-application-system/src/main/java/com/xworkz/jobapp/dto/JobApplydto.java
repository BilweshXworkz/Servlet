package com.xworkz.jobapp.dto;

import lombok.Data;

@Data
public class JobApplydto {
    private Integer id;
    private String  firstName;
    private String  lastName;
    private Long phoneNumber;
    private String  emailId;
    private String  jobApplying;
}
