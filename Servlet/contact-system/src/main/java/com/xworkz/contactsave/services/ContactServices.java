package com.xworkz.contactsave.services;

import com.xworkz.contactsave.dto.ContactDto;

import java.util.List;

public interface ContactServices {
    Boolean validAndSave(ContactDto dto);
    List<ContactDto> getContact();
    void deleteById(int id);
    ContactDto getDonationById(int id);
    void updateContact(ContactDto dto);
}
