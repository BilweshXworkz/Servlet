package com.xworkz.hotelapp.services;

import com.xworkz.hotelapp.dto.RoomOrderDto;
import com.xworkz.hotelapp.entity.RoomOrderEntity;
import com.xworkz.hotelapp.repository.RoomRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class RoomOrderServicesImpl implements RoomOrderServices {
    RoomRepositoryImpl roomRepository = new RoomRepositoryImpl();
    @Override
    public Boolean validAndSave(RoomOrderDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<RoomOrderEntity>> validate = validator.validate(new RoomOrderEntity());
        if (!validate.isEmpty()){
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        RoomOrderEntity entity = new RoomOrderEntity();
        try{
            BeanUtils.copyProperties(entity, dto);
            Boolean isAdded = roomRepository.save(entity);
            return isAdded;
        }
        catch (IllegalAccessException| InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
