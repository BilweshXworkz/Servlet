package com.xworkz.jobapp.services;

import com.xworkz.jobapp.dto.JobApplydto;
import com.xworkz.jobapp.entity.JobApplyEntity;
import com.xworkz.jobapp.repository.JobApplyRepository;
import com.xworkz.jobapp.repository.JobApplyRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class JobApplyServicesImpl implements JobApplyServices{
    JobApplyRepository jobApplyRepository = new JobApplyRepositoryImpl();

    @Override
    public Boolean ValidAndSave(JobApplydto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<JobApplyEntity>> validate = validator.validate(new JobApplyEntity());
        if (!validate.isEmpty()){
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        JobApplyEntity entity = new JobApplyEntity();
        try{
            BeanUtils.copyProperties(entity, dto);
            Boolean isAdded = jobApplyRepository.save(entity);
            return isAdded;
        }
        catch (IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
