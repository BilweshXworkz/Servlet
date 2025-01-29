package com.xworkz.travelapp.services;

import com.xworkz.travelapp.dto.TravelBookingDto;
import com.xworkz.travelapp.entity.TravelingBookingEntity;
import com.xworkz.travelapp.repository.TravelBookingRepository;
import com.xworkz.travelapp.repository.TravelBookingRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class TravelBookingServicesImpl implements TravelBookingServices{
    TravelBookingRepository travelBookingRepository = new TravelBookingRepositoryImpl();
    @Override
    public Boolean validAndSave(TravelBookingDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<TravelingBookingEntity>> validate = validator.validate(new TravelingBookingEntity());
        if (!validate.isEmpty()){
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        TravelingBookingEntity entity = new TravelingBookingEntity();
        try{
            BeanUtils.copyProperties(entity, dto);
            Boolean isAdded =travelBookingRepository.save(entity);
            return isAdded;
        }
        catch (IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
