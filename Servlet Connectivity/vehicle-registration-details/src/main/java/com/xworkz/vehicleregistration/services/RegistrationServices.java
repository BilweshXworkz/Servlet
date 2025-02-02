package com.xworkz.vehicleregistration.services;

import com.xworkz.vehicleregistration.dto.RegistrationDto;

import java.util.List;

public interface RegistrationServices {
    Boolean validAndSave(RegistrationDto dto);
    List<RegistrationDto> getRegistration();
    void deleteById(int id);
}
