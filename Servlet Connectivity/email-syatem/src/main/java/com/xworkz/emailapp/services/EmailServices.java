package com.xworkz.emailapp.services;

import com.xworkz.emailapp.dto.EmailDto;

public interface EmailServices {
    Boolean validAndSave(EmailDto dto);
}
