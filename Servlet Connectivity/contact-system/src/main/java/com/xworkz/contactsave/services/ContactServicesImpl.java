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
}
