package com.xworkz.emailapp.repository;

import com.xworkz.emailapp.entity.EmailEntity;

public interface EmailRepository {
    Boolean save(EmailEntity emailEntity);
}
