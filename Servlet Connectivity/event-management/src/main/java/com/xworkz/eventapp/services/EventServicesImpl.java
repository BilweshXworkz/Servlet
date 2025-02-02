package com.xworkz.eventapp.services;

import com.xworkz.eventapp.dto.EventDto;
import com.xworkz.eventapp.entity.EventEntity;
import com.xworkz.eventapp.repository.EventRepository;
import com.xworkz.eventapp.repository.EventRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class EventServicesImpl implements EventServices{
    EventRepository eventRepository = new EventRepositoryImpl();
    @Override
    public Boolean validAndSave(EventDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<EventEntity>> validate = validator.validate(new EventEntity());
        if (!validate.isEmpty()){
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        EventEntity entity = new EventEntity();
        try{
            BeanUtils.copyProperties(entity, dto);
            Boolean isAdded = eventRepository.save(entity);
            return isAdded;
        }
        catch (IllegalAccessException| InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<EventDto> getEvent() {
        List<EventEntity> entities = eventRepository.getEventDetails();
        List<EventDto> dtoList = new ArrayList<>();
        try{
            for (EventEntity entity : entities){
                EventDto dto = new EventDto();
                BeanUtils.copyProperties(dto, entity);
                dtoList.add(dto);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return dtoList;
    }

    public void deleteById(int id) {
        eventRepository.deleteById(id);
        if (eventRepository != null) {
            eventRepository.deleteById(id);
            System.out.println("User profile with id " + id + " deleted successfully");
        } else {
            System.out.println("User profile with id " + id + " not found");
        }
    }
}
