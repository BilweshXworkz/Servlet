package com.xworkz.donationapp.dto;

import lombok.Data;

@Data
public class DonationDto {
    private String  name;
    private Long phoneNumber;
    private Integer dAmount;
    private Integer payment;
}
