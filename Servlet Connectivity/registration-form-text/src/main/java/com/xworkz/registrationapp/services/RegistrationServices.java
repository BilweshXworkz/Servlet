package com.xworkz.registrationapp.services;

import com.xworkz.registrationapp.dto.RegistrationDto;

public interface RegistrationServices {
    Boolean validAndSave(RegistrationDto dto);
}
