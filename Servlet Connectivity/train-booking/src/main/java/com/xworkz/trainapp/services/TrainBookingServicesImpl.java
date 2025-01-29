package com.xworkz.trainapp.services;

import com.xworkz.trainapp.dto.TrainBookingDto;
import com.xworkz.trainapp.entity.TrainBookingEntity;
import com.xworkz.trainapp.repository.TrainBookingRepository;
import com.xworkz.trainapp.repository.TrainBookingRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class TrainBookingServicesImpl implements TrainBookingServices{
    TrainBookingRepository trainBookingRepository = new TrainBookingRepositoryImpl();
    @Override
    public Boolean validAndSave(TrainBookingDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<TrainBookingEntity>> validate = validator.validate(new TrainBookingEntity());
        if (!validate.isEmpty()){
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        TrainBookingEntity entity = new TrainBookingEntity();
        try{
            BeanUtils.copyProperties(entity, dto);
            Boolean isAdded = trainBookingRepository.save(entity);
            return isAdded;
        }
        catch (IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
