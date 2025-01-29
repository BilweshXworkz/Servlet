package com.xworkz.bankingapp.services;

import com.xworkz.bankingapp.dto.DepositoryDto;
import com.xworkz.bankingapp.entity.DepositoryEntity;
import com.xworkz.bankingapp.repository.DepositoryRepository;
import com.xworkz.bankingapp.repository.DepositoryRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.*;
import java.lang.reflect.InvocationTargetException;
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
}