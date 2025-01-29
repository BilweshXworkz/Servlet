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
}
