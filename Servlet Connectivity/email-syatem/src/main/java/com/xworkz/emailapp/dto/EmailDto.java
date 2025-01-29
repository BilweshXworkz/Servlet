package com.xworkz.emailapp.dto;

import lombok.Data;

@Data

public class EmailDto {
    private String toMail;
    private String subject;
    private String content;
}
