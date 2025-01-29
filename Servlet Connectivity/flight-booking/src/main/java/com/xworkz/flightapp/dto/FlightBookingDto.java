package com.xworkz.flightapp.dto;

import lombok.Data;

@Data
public class FlightBookingDto {
    private String firstName;
    private String from;
    private String departure;
    private String returns;
    private Integer number;
}
