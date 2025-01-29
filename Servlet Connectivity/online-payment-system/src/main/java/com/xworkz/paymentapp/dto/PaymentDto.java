package com.xworkz.paymentapp.dto;

import lombok.Data;

@Data

public class PaymentDto {
    private String firstName;
    private Long phoneNumber;
    private String ifsCode;
    private Long account;
    private Integer amount;
}
