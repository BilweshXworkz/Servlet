package com.xworkz.bankingapp.dto;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

@Data

public class DepositoryDto {
    private Integer id;
    private String fullName;
    private String dob;
    private String emailId;
    private Long acNumber;
    private Integer depository;
}
