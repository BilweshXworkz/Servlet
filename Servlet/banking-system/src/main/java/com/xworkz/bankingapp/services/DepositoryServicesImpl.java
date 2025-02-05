package com.xworkz.bankingapp.services;

import com.xworkz.bankingapp.dto.DepositoryDto;
import com.xworkz.bankingapp.entity.DepositoryEntity;
import com.xworkz.bankingapp.repository.DepositoryRepository;
import com.xworkz.bankingapp.repository.DepositoryRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.*;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class DepositoryServicesImpl implements DepositoryServices {
    DepositoryRepository depositoryRepository = new DepositoryRepositoryImpl();
    @Override
    public boolean validAndSave(DepositoryDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<DepositoryEntity>> validate = validator.validate(new DepositoryEntity());
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        DepositoryEntity entity = new DepositoryEntity();
        try {
            BeanUtils.copyProperties(entity, dto);
            Boolean isAdded = depositoryRepository.save(entity);
            return isAdded;
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<DepositoryDto> GetDepository() {
        List<DepositoryEntity> depositoryEntities = depositoryRepository.getDepositoryDetails();
        List<DepositoryDto> dtoList = new ArrayList<>();
        try{
            for (DepositoryEntity entity : depositoryEntities){
                DepositoryDto dto = new DepositoryDto();
                BeanUtils.copyProperties(dto, entity);
                dtoList.add(dto);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return dtoList;
    }

    public void deleteById(int id) {
        depositoryRepository.deleteById(id);
        if (depositoryRepository != null) {
            depositoryRepository.deleteById(id);
            System.out.println("User profile with id " + id + " deleted successfully");
        } else {
            System.out.println("User profile with id " + id + " not found");
        }
    }

    @Override
    public DepositoryDto getDepositoryById(int id) {
        if (id > 0){
            DepositoryDto dto = new DepositoryDto();
            DepositoryEntity entity = depositoryRepository.getDepositoryById(id);
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
    public void updateDepository(DepositoryDto dto) {
        DepositoryEntity entity = new DepositoryEntity();
        try{
            BeanUtils.copyProperties(entity, dto);
            depositoryRepository.updateDepository(entity);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}