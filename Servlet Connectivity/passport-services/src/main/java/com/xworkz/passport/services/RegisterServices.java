package com.xworkz.passport.services;

import com.xworkz.passport.dto.RegisterDto;

public interface RegisterServices {
    Boolean validAndSave(RegisterDto dto);
}
