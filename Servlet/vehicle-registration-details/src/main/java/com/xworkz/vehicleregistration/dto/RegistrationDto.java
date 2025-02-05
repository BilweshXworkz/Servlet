package com.xworkz.vehicleregistration.dto;

import lombok.Data;

@Data

public class RegistrationDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private String emailId;
    private String  vehicleName;
    private String vehicleType;
    private Integer code;
}
