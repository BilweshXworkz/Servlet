package com.xworkz.contactsave.repository;

import com.xworkz.contactsave.entity.ContactEntity;

import java.util.List;

public interface ContactRepository {
    Boolean save (ContactEntity contactEntity);
    List<ContactEntity> getContactDetails();
    void deleteById(int id);
    ContactEntity getDonationById(int id);
    void updateContact(ContactEntity entity);
}
