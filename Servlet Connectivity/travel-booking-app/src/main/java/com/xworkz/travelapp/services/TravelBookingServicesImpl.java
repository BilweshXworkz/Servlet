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
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<TravelBookingDto> getBooking() {
        List<TravelingBookingEntity> entities = travelBookingRepository.getBookingDetails();
        List<TravelBookingDto> dtoList = new ArrayList<>();
        try{
            for (TravelingBookingEntity entity : entities){
                TravelBookingDto dto = new TravelBookingDto();
                BeanUtils.copyProperties(dto, entity);
                dtoList.add(dto);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return dtoList;
    }

    public void deleteById(int id) {
        travelBookingRepository.deleteById(id);
        if (travelBookingRepository != null) {
            travelBookingRepository.deleteById(id);
            System.out.println("User profile with id " + id + " deleted successfully");
        } else {
            System.out.println("User profile with id " + id + " not found");
        }
    }

    @Override
    public TravelBookingDto getBookingById(int id) {
        if (id > 0){
            TravelBookingDto dto = new TravelBookingDto();
            TravelingBookingEntity entity = travelBookingRepository.getBookingById(id);
            try {
                BeanUtils.copyProperties(dto, entity);
                return dto;
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public void updateBooking(TravelBookingDto dto) {
        TravelingBookingEntity entity = new TravelingBookingEntity();
        try{
            BeanUtils.copyProperties(entity, dto);
            travelBookingRepository.updateBooking(entity);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
