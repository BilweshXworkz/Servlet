package com.xworkz.emailapp.services;

import com.xworkz.emailapp.dto.EmailDto;
import com.xworkz.emailapp.entity.EmailEntity;
import com.xworkz.emailapp.repository.EmailRepository;
import com.xworkz.emailapp.repository.EmailRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class EmailServicesImpl implements EmailServices{
    EmailRepository emailRepository = new EmailRepositoryImpl();

    @Override
    public Boolean validAndSave(EmailDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<EmailEntity>> validate = validator.validate(new EmailEntity());
        if (!validate.isEmpty()){
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        EmailEntity entity = new EmailEntity();
        try{
            BeanUtils.copyProperties(entity, dto);
            Boolean isAdded = emailRepository.save(entity);
            return isAdded;
        }
        catch (IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
