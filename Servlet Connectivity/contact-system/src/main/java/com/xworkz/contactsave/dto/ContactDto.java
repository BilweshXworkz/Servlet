package com.xworkz.contactsave.dto;

import lombok.Data;

@Data

public class ContactDto {
    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private String emailId;
    private String description;
}
