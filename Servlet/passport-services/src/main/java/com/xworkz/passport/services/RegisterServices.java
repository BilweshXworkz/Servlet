package com.xworkz.passport.services;

import com.xworkz.passport.dto.RegisterDto;

import java.util.List;

public interface RegisterServices {
    Boolean validAndSave(RegisterDto dto);
    List<RegisterDto> getRegister();
    void deleteById(int id);
    RegisterDto getProfileById(int id);
    void UpdateProfile (RegisterDto dto);
}
