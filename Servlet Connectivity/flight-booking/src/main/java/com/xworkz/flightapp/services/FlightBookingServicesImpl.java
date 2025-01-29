package com.xworkz.flightapp.services;

import com.xworkz.flightapp.dto.FlightBookingDto;
import com.xworkz.flightapp.entity.FlightBookingEntity;
import com.xworkz.flightapp.repository.FlightBookingRepository;
import com.xworkz.flightapp.repository.FlightBookingRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.enterprise.inject.spi.Bean;
import javax.validation.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class FlightBookingServicesImpl implements FlightBookingServices {
    FlightBookingRepository flightBookingRepository = new FlightBookingRepositoryImpl();

    @Override
    public boolean valideAndSave(FlightBookingDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator =validatorFactory.getValidator();
        Set<ConstraintViolation<FlightBookingEntity>> validate = validator.validate(new FlightBookingEntity());
        if (!validate.isEmpty()){
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        FlightBookingEntity entity = new FlightBookingEntity();
        try{
            System.out.println("Service Dto :"+dto);
            BeanUtils.copyProperties(entity, dto);
            System.out.println("Service Entity :"+entity);
            Boolean isAdded = flightBookingRepository.save(entity);
            return isAdded;
        }catch (IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
