package com.xworkz.hotelapp.services;

import com.xworkz.hotelapp.dto.RoomOrderDto;
import com.xworkz.hotelapp.entity.RoomOrderEntity;
import com.xworkz.hotelapp.repository.RoomRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<RoomOrderDto> getRoom() {
        List<RoomOrderEntity> entities = roomRepository.getOrderDetails();
        List<RoomOrderDto> dtoList = new ArrayList<>();
        try{
            for (RoomOrderEntity entity : entities){
                RoomOrderDto dto = new RoomOrderDto();
                BeanUtils.copyProperties(dto, entity);
                dtoList.add(dto);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return dtoList;
    }

    public void deleteById(int id) {
        roomRepository.deleteById(id);
        if (roomRepository != null) {
            roomRepository.deleteById(id);
            System.out.println("User profile with id " + id + " deleted successfully");
        } else {
            System.out.println("User profile with id " + id + " not found");
        }
    }
}
