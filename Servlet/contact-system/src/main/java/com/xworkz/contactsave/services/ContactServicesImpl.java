package com.xworkz.contactsave.services;

import com.xworkz.contactsave.dto.ContactDto;
import com.xworkz.contactsave.entity.ContactEntity;
import com.xworkz.contactsave.repository.ContactRepository;
import com.xworkz.contactsave.repository.ContactRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ContactServicesImpl implements ContactServices{
    ContactRepository contactRepository = new ContactRepositoryImpl();

    @Override
    public Boolean validAndSave(ContactDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<ContactEntity>> validate = validator.validate(new ContactEntity());
        if (!validate.isEmpty()){
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        ContactEntity entity = new ContactEntity();
        try{
            BeanUtils.copyProperties(entity, dto);
            Boolean isAdded = contactRepository.save(entity);
            return isAdded;
        }
        catch (IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<ContactDto> getContact() {
        List<ContactEntity> entities = contactRepository.getContactDetails();
        List<ContactDto> dtoList = new ArrayList<>();
        try{
            for (ContactEntity entity : entities){
                ContactDto dto = new ContactDto();
                BeanUtils.copyProperties(dto, entity);
                dtoList.add(dto);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return dtoList;
    }

    public void deleteById(int id) {
        contactRepository.deleteById(id);
        if (contactRepository != null) {
            contactRepository.deleteById(id);
            System.out.println("User profile with id " + id + " deleted successfully");
        } else {
            System.out.println("User profile with id " + id + " not found");
        }
    }

    @Override
    public ContactDto getDonationById(int id) {
        if (id > 0){
            ContactDto dto = new ContactDto();
            ContactEntity entity = contactRepository.getDonationById(id);
            try {
                BeanUtils.copyProperties(dto, entity);
                return dto;
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public void updateContact(ContactDto dto) {
        ContactEntity entity = new ContactEntity();
        try{
            BeanUtils.copyProperties(entity, dto);
            contactRepository.updateContact(entity);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
