package com.xworkz.collegapp.services;

import com.xworkz.collegapp.dto.CollegeApplicationDto;
import com.xworkz.collegapp.entity.CollegeApplicationEntity;
import com.xworkz.collegapp.repository.CollegeApplicationRepository;
import com.xworkz.collegapp.repository.CollegeApplicationRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;


public class CollegeApplicationServicesImpl implements CollegeApplicationServices {
    CollegeApplicationRepository collegeApplicationRepository = new CollegeApplicationRepositoryImpl();

    @Override
    public Boolean ValidAndSave(CollegeApplicationDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<CollegeApplicationEntity>> validate = validator.validate(new CollegeApplicationEntity());
        if (!validate.isEmpty()){
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        CollegeApplicationEntity entity = new CollegeApplicationEntity();
        try{
            BeanUtils.copyProperties(entity, dto);
            Boolean isAdded = collegeApplicationRepository.save(entity);
            return isAdded;
        }
        catch (IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
