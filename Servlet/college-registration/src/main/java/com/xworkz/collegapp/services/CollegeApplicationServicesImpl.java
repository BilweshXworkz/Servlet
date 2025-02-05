package com.xworkz.collegapp.services;

import com.xworkz.collegapp.dto.CollegeApplicationDto;
import com.xworkz.collegapp.entity.CollegeApplicationEntity;
import com.xworkz.collegapp.repository.CollegeApplicationRepository;
import com.xworkz.collegapp.repository.CollegeApplicationRepositoryImpl;
import io.quarkus.runtime.util.StepTiming;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    @Override
    public List<CollegeApplicationDto> getApplication() {
        List<CollegeApplicationEntity> collegeApplicationEntities = collegeApplicationRepository.getCollegeApplicationDetails();
        List<CollegeApplicationDto> dtoList =new ArrayList<>();
        try{
            for (CollegeApplicationEntity entity : collegeApplicationEntities){
                CollegeApplicationDto dto = new CollegeApplicationDto();
                BeanUtils.copyProperties(dto, entity);
                dtoList.add(dto);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return dtoList;
    }

    public void deleteById(int id) {
        collegeApplicationRepository.deleteById(id);
        if (collegeApplicationRepository != null) {
            collegeApplicationRepository.deleteById(id);
            System.out.println("User profile with id " + id + " deleted successfully");
        } else {
            System.out.println("User profile with id " + id + " not found");
        }
    }

    @Override
    public CollegeApplicationDto getProfileById(Integer id) {
        if (id > 0){
            CollegeApplicationDto dto = new CollegeApplicationDto();
            CollegeApplicationEntity entity = collegeApplicationRepository.getById(id);
            try{
                BeanUtils.copyProperties(dto, entity);
                return dto;
            }
            catch (IllegalAccessException | InvocationTargetException e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public void updateProfile(CollegeApplicationDto dto) {
        CollegeApplicationEntity entity = new CollegeApplicationEntity();
        try{
            BeanUtils.copyProperties(entity, dto);
            collegeApplicationRepository.updateProfile(entity);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
