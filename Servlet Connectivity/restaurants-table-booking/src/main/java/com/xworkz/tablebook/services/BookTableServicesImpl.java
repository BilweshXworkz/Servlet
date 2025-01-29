package com.xworkz.tablebook.services;

import com.xworkz.tablebook.dto.BookTableDto;
import com.xworkz.tablebook.entity.BookTableEntity;
import com.xworkz.tablebook.repository.BookTableRepository;
import com.xworkz.tablebook.repository.BookTableRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class BookTableServicesImpl implements BookTableServices{
    BookTableRepository bookTableRepository = new BookTableRepositoryImpl();
    @Override
    public Boolean validAndSave(BookTableDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<BookTableEntity>> validate = validator.validate(new BookTableEntity());
        if (!validate.isEmpty()){
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        BookTableEntity entity = new BookTableEntity();
        try{
            BeanUtils.copyProperties(entity, dto);
            Boolean isAdded = bookTableRepository.save(entity);
            return isAdded;
        }
        catch (IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
