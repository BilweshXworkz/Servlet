package com.xworkz.registrationapp.services;

import com.xworkz.registrationapp.dto.RegistrationDto;
import com.xworkz.registrationapp.entity.RegistrationEntity;
import com.xworkz.registrationapp.repository.RegistrationRepository;
import com.xworkz.registrationapp.repository.RegistrationRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class RegistrationServicesImpl implements RegistrationServices {
    RegistrationRepository registrationRepository = new RegistrationRepositoryImpl();

    @Override
    public Boolean validAndSave(RegistrationDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<RegistrationEntity>> validate = validator.validate(new RegistrationEntity());
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        RegistrationEntity entity = new RegistrationEntity();
        try {
            BeanUtils.copyProperties(entity, dto);
            Boolean isAdded = registrationRepository.Save(entity);
            return isAdded;
        } catch (InvocationTargetException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
