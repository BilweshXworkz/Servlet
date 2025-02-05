package com.xworkz.vehicleregistration.services;

import com.xworkz.vehicleregistration.dto.RegistrationDto;
import com.xworkz.vehicleregistration.entity.RegistrationEntity;
import com.xworkz.vehicleregistration.repository.RegistrationRepository;
import com.xworkz.vehicleregistration.repository.RegistrationRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RegistrationServicesImpl implements RegistrationServices{
    RegistrationRepository repository = new RegistrationRepositoryImpl();

    @Override
    public Boolean validAndSave(RegistrationDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<RegistrationEntity>> validate = validator.validate(new RegistrationEntity());
        if (!validate.isEmpty()){
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        RegistrationEntity entity = new RegistrationEntity();
        try{
            BeanUtils.copyProperties(entity, dto);
            Boolean isAdded = repository.save(entity);
            return isAdded;
        }
        catch (IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<RegistrationDto> getRegistration() {
        List<RegistrationEntity> entities = repository.getRegistrationDetails();
        List<RegistrationDto> dtoList = new ArrayList<>();
        try{
            for (RegistrationEntity entity : entities){
                RegistrationDto dto = new RegistrationDto();
                BeanUtils.copyProperties(dto, entity);
                dtoList.add(dto);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return dtoList;
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
        if (repository != null) {
            repository.deleteById(id);
            System.out.println("User profile with id " + id + " deleted successfully");
        } else {
            System.out.println("User profile with id " + id + " not found");
       }
    }

    @Override
    public RegistrationDto getRegistrationById(int id) {
        if (id > 0){
            RegistrationDto dto = new RegistrationDto();
            RegistrationEntity entity = repository.getRegistrationById(id);
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
    public void updateRegisteration(RegistrationDto dto) {
        RegistrationDto entity = new RegistrationDto();
        try{
            BeanUtils.copyProperties(entity, dto);
            repository.updateRegistration(entity);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
