package com.xworkz.flightapp.services;

import com.xworkz.flightapp.dto.FlightBookingDto;
import com.xworkz.flightapp.entity.FlightBookingEntity;
import com.xworkz.flightapp.repository.FlightBookingRepository;
import com.xworkz.flightapp.repository.FlightBookingRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
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
            BeanUtils.copyProperties(entity, dto);
            Boolean isAdded = flightBookingRepository.save(entity);
            return isAdded;
        }catch (IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<FlightBookingDto> getflight() {
        List<FlightBookingEntity> entities = flightBookingRepository.getFlightDetails();
        List<FlightBookingDto> dtoList = new ArrayList<>();
        try{
            for (FlightBookingEntity entity : entities){
                FlightBookingDto dto = new FlightBookingDto();
                BeanUtils.copyProperties(dto, entity);
                dtoList.add(dto);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return dtoList;
    }
    public void deleteById(int id) {
        flightBookingRepository.deleteById(id);
        if (flightBookingRepository != null) {
            flightBookingRepository.deleteById(id);
            System.out.println("User profile with id " + id + " deleted successfully");
        } else {
            System.out.println("User profile with id " + id + " not found");
        }
    }
}
