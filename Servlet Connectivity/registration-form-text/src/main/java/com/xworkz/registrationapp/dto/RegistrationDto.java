package com.xworkz.registrationapp.dto;

import lombok.Data;

@Data

public class RegistrationDto {
    private Integer id;
    private String userName;
    private String email;
    private Long contact;
    private String education;
    private String job;
}
