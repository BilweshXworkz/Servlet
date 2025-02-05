package com.xworkz.emailapp.repository;

import com.xworkz.emailapp.entity.EmailEntity;

import java.util.List;

public interface EmailRepository {
    Boolean save(EmailEntity emailEntity);
    List<EmailEntity> getEmailDetails();
    void deleteByToEmail(String toEmail);
    EmailEntity getEmailById(int id);
    void updateEmail(EmailEntity entity);
}
