package com.xworkz.passport.services;

import com.xworkz.passport.dto.RegisterDto;
import com.xworkz.passport.entity.RegisterEntity;
import com.xworkz.passport.repository.RegisterRepository;
import com.xworkz.passport.repository.RegisterRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RegisterServicesImpl implements RegisterServices {
RegisterRepository registerRepository = new RegisterRepositoryImpl();

    @Override
    public Boolean validAndSave(RegisterDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<RegisterEntity>> validate = validator.validate(new RegisterEntity());
        if (!validate.isEmpty()){
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        RegisterEntity entity = new RegisterEntity();
        try{
            BeanUtils.copyProperties(entity, dto);
            Boolean isAdded = registerRepository.save(entity);
            return isAdded;
        }
        catch (IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public List<RegisterDto> getRegister() {
        List<RegisterEntity> entities = registerRepository.getRegisterDetails();
        List<RegisterDto> dtoList = new ArrayList<>();
        try{
            for (RegisterEntity entity : entities){
                RegisterDto dto = new RegisterDto();
                BeanUtils.copyProperties(dto, entity);
                dtoList.add(dto);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return dtoList;
    }

    public void deleteById(int id) {
        registerRepository.deleteById(id);
        if (registerRepository != null) {
            registerRepository.deleteById(id);
            System.out.println("User profile with id " + id + " deleted successfully");
        } else {
            System.out.println("User profile with id " + id + " not found");
        }
    }

    @Override
    public RegisterDto getProfileById(int id) {
        if (id > 0){
            RegisterDto dto = new RegisterDto();
            RegisterEntity entity = registerRepository.getProfileById(id);
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
    public void UpdateProfile(RegisterDto dto) {
        RegisterEntity entity = new RegisterEntity();
        try{
            BeanUtils.copyProperties(entity, dto);
            registerRepository.updateProfile(entity);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
