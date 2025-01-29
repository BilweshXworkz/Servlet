package com.xworkz.shoppingapp.services;

import com.xworkz.shoppingapp.dto.ShoppingDto;
import com.xworkz.shoppingapp.entity.ShoppingEntity;
import com.xworkz.shoppingapp.repository.ShoppingRepository;
import com.xworkz.shoppingapp.repository.ShoppingRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class ShoppingServicesImpl implements ShoppingServices {
    ShoppingRepository shoppingRepository = new ShoppingRepositoryImpl();

    @Override
    public Boolean ValidAndSave(ShoppingDto shoppingDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<ShoppingEntity>> validate = validator.validate(new ShoppingEntity());
        if (!validate.isEmpty()){
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        ShoppingEntity entity = new ShoppingEntity();
        try{
            BeanUtils.copyProperties(entity, shoppingDto);
            Boolean isAdded = shoppingRepository.save(entity);
            return isAdded;
        }
        catch (IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
