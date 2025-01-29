package com.xworkz.contactsave.services;

import com.xworkz.contactsave.dto.ContactDto;

public interface ContactServices {
    Boolean validAndSave(ContactDto dto);
}
