package com.xworkz.appointmentapp.services;

import com.xworkz.appointmentapp.dto.AppointmentDto;
import com.xworkz.appointmentapp.entity.AppointmentEntity;
import com.xworkz.appointmentapp.repository.AppointmentRepository;
import com.xworkz.appointmentapp.repository.AppointmentRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class AppointmentServicesImpl implements AppointmentServices {
   AppointmentRepository appointmentRepository = new AppointmentRepositoryImpl();

    @Override
    public boolean valideAndSave(AppointmentDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator =validatorFactory.getValidator();
        Set<ConstraintViolation<AppointmentEntity>> validate = validator.validate(new AppointmentEntity());
        if (!validate.isEmpty()){
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        AppointmentEntity entity = new AppointmentEntity();
        try{
            System.out.println("Service Dto :"+dto);
            BeanUtils.copyProperties(entity, dto);
            System.out.println("Service Entity :"+entity);
            Boolean isAdded = appointmentRepository.save(entity);
            return isAdded;
        }catch (IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
