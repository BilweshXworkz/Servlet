package com.xworkz.vehicleregistration.repository;

import com.xworkz.vehicleregistration.entity.RegistrationEntity;

import java.util.List;

public interface RegistrationRepository {
    Boolean save(RegistrationEntity registrationEntity);
    List<RegistrationEntity> getRegistrationDetails();
    void deleteById(int id);
}
