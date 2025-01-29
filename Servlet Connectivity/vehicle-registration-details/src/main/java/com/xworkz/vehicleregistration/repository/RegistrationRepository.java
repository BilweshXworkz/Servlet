package com.xworkz.vehicleregistration.repository;

import com.xworkz.vehicleregistration.dto.RegistrationDto;
import com.xworkz.vehicleregistration.entity.RegistrationEntity;

public interface RegistrationRepository {
    Boolean save(RegistrationEntity registrationEntity);
}
