package com.xworkz.feedbackapp.dto;

import lombok.Data;

@Data
public class FeedbackDto {
    private String firstName;
    private String  lastName;
    private Long phoneNumber;
    private String emailId;
    private String education;
}
