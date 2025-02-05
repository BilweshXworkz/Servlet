package com.xworkz.feedbackapp.services;

import com.xworkz.feedbackapp.dto.FeedbackDto;
import com.xworkz.feedbackapp.entity.FeedbackEntity;
import com.xworkz.feedbackapp.repository.FeedbackRepository;
import com.xworkz.feedbackapp.repository.FeedbackRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class FeedbackServicesImpl implements FeedbackServices {
    FeedbackRepository feedbackRepository = new FeedbackRepositoryImpl();

    @Override
    public Boolean ValidAndSave(FeedbackDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<FeedbackEntity>> validate = validator.validate(new FeedbackEntity());
        if (!validate.isEmpty()){
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        FeedbackEntity entity = new FeedbackEntity();
        try{
            BeanUtils.copyProperties(entity, dto);
            Boolean isAdded = feedbackRepository.save(entity);
            return isAdded;
        }
        catch (IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<FeedbackDto> getFeedback() {
        List<FeedbackEntity> entities = feedbackRepository.getFeedbackDetails();
        List<FeedbackDto> dtoList = new ArrayList<>();
        try{
            for (FeedbackEntity entity : entities){
                FeedbackDto dto = new FeedbackDto();
                BeanUtils.copyProperties(dto, entity);
                dtoList.add(dto);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return dtoList;
    }

    public void deleteById(int id) {
        feedbackRepository.deleteById(id);
        if (feedbackRepository != null) {
            feedbackRepository.deleteById(id);
            System.out.println("User profile with id " + id + " deleted successfully");
        } else {
            System.out.println("User profile with id " + id + " not found");
        }
    }

    @Override
    public FeedbackDto updateById(Integer id) {
        if (id > 0){
            FeedbackDto dto = new FeedbackDto();
            FeedbackEntity entity = new FeedbackEntity();
            try{
                BeanUtils.copyProperties(dto,entity);
                return dto;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public void updateProfile(FeedbackDto dto) {
        FeedbackEntity entity =new FeedbackEntity();
        try{
            BeanUtils.copyProperties(entity, dto);
            feedbackRepository.updateProfile(entity);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
