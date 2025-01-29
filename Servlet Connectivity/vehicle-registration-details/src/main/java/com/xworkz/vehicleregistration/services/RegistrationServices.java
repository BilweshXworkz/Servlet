package com.xworkz.vehicleregistration.services;

import com.xworkz.vehicleregistration.dto.RegistrationDto;

public interface RegistrationServices {
    Boolean validAndSave(RegistrationDto dto);
}
