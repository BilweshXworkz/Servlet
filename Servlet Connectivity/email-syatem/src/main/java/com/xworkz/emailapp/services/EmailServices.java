package com.xworkz.emailapp.services;

import com.xworkz.emailapp.dto.EmailDto;

import java.util.List;

public interface EmailServices {
    Boolean validAndSave(EmailDto dto);
    List<EmailDto> getEmail();
    void deleteByToEmail(String toEmail);
    EmailDto getEmailByProfile(int id);
    void updateMail(EmailDto dto);
}
