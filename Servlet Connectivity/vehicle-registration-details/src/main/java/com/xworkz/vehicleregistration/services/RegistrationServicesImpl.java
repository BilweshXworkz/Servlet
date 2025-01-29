package com.xworkz.vehicleregistration.services;

import com.xworkz.vehicleregistration.dto.RegistrationDto;
import com.xworkz.vehicleregistration.entity.RegistrationEntity;
import com.xworkz.vehicleregistration.repository.RegistrationRepository;
import com.xworkz.vehicleregistration.repository.RegistrationRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.rmi.registry.Registry;
import java.util.Set;

public class RegistrationServicesImpl implements RegistrationServices{
    RegistrationRepository repository = new RegistrationRepositoryImpl();

    @Override
    public Boolean validAndSave(RegistrationDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<RegistrationEntity>> validate = validator.validate(new RegistrationEntity());
        if (!validate.isEmpty()){
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        RegistrationEntity entity = new RegistrationEntity();
        try{
            BeanUtils.copyProperties(entity, dto);
            Boolean isAdded = repository.save(entity);
            return isAdded;
        }
        catch (IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
