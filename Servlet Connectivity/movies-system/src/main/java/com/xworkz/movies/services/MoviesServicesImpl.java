package com.xworkz.movies.services;

import com.xworkz.movies.dto.MoviesDto;
import com.xworkz.movies.entity.MoviesEntity;
import com.xworkz.movies.repository.MoviesRepository;
import com.xworkz.movies.repository.MoviesRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class MoviesServicesImpl implements MoviesServices{
    MoviesRepository moviesRepository = new MoviesRepositoryImpl();

    @Override
    public Boolean validAndSave(MoviesDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<MoviesEntity>> validate = validator.validate(new MoviesEntity());
        if (!validate.isEmpty()){
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        MoviesEntity entity = new MoviesEntity();
        try{
            BeanUtils.copyProperties(entity, dto);
            Boolean isAdded = moviesRepository.save(entity);
            return isAdded;
        }
        catch (IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
