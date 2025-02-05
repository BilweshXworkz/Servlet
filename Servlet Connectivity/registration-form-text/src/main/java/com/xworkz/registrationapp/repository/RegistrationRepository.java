package com.xworkz.registrationapp.repository;

import com.xworkz.registrationapp.entity.RegistrationEntity;

public interface RegistrationRepository {
    Boolean Save(RegistrationEntity registrationEntity);
}
