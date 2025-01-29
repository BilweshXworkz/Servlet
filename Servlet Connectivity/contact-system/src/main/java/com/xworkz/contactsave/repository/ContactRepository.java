package com.xworkz.contactsave.repository;

import com.xworkz.contactsave.entity.ContactEntity;

public interface ContactRepository {
    Boolean save (ContactEntity contactEntity);
}
