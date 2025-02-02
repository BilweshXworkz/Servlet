package com.xworkz.trainapp.services;

import com.xworkz.trainapp.dto.TrainBookingDto;
import com.xworkz.trainapp.entity.TrainBookingEntity;
import com.xworkz.trainapp.repository.TrainBookingRepository;
import com.xworkz.trainapp.repository.TrainBookingRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<TrainBookingDto> getTrain() {
        List<TrainBookingEntity> entities = trainBookingRepository.getTrainDetails();
        List<TrainBookingDto> dtoList = new ArrayList<>();
        try{
            for (TrainBookingEntity entity : entities){
                TrainBookingDto dto = new TrainBookingDto();
                BeanUtils.copyProperties(dto, entity);
                dtoList.add(dto);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return dtoList;
    }

    public void deleteById(int id) {
        trainBookingRepository.deleteById(id);
        if (trainBookingRepository != null) {
            trainBookingRepository.deleteById(id);
            System.out.println("User profile with id " + id + " deleted successfully");
        } else {
            System.out.println("User profile with id " + id + " not found");
        }
    }
}
