package com.xworkz.appointmentapp.dto;

import lombok.Data;

@Data
public class AppointmentDto {
    private Integer id;
    private String Name;
    private Long phoneNumber;
    private String emailid;
    private String adate;
}
