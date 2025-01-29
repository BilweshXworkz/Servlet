package com.xworkz.passport.services;

import com.xworkz.passport.dto.RegisterDto;
import com.xworkz.passport.entity.RegisterEntity;
import com.xworkz.passport.repository.RegisterRepository;
import com.xworkz.passport.repository.RegisterRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class RegisterServicesImpl implements RegisterServices {
RegisterRepository registerRepository = new RegisterRepositoryImpl();

    @Override
    public Boolean validAndSave(RegisterDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<RegisterEntity>> validate = validator.validate(new RegisterEntity());
        if (!validate.isEmpty()){
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        RegisterEntity entity = new RegisterEntity();
        try{
            BeanUtils.copyProperties(entity, dto);
            Boolean isAdded = registerRepository.save(entity);
            return isAdded;
        }
        catch (IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
