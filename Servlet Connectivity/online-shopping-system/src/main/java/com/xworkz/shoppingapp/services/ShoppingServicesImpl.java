package com.xworkz.shoppingapp.services;

import com.xworkz.shoppingapp.dto.ShoppingDto;
import com.xworkz.shoppingapp.entity.ShoppingEntity;
import com.xworkz.shoppingapp.repository.ShoppingRepository;
import com.xworkz.shoppingapp.repository.ShoppingRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<ShoppingDto> getShopping() {
        List<ShoppingEntity> entities = shoppingRepository.getShoppingDetails();
        List<ShoppingDto> dtoList = new ArrayList<>();
        try{
            for (ShoppingEntity entity : entities){
                ShoppingDto dto = new ShoppingDto();
                BeanUtils.copyProperties(dto, entity);
                dtoList.add(dto);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return dtoList;
    }

    public void deleteById(int id) {
        shoppingRepository.deleteById(id);
        if (shoppingRepository != null) {
            shoppingRepository.deleteById(id);
            System.out.println("User profile with id " + id + " deleted successfully");
        } else {
            System.out.println("User profile with id " + id + " not found");
        }
    }
}
