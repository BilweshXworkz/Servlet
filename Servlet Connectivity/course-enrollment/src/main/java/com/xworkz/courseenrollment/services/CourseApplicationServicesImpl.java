package com.xworkz.courseenrollment.services;

import com.xworkz.courseenrollment.dto.CourseApplicationDto;
import com.xworkz.courseenrollment.entity.CourseApplicationEntity;
import com.xworkz.courseenrollment.repository.CourseApplicationRepository;
import com.xworkz.courseenrollment.repository.CourseApplicationRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class CourseApplicationServicesImpl implements CourseApplicationServices {
    CourseApplicationRepository courseApplicationRepository = new CourseApplicationRepositoryImpl();

    @Override
    public Boolean ValidAndSave(CourseApplicationDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<CourseApplicationEntity>> validate = validator.validate(new CourseApplicationEntity());
        if (!validate.isEmpty()){
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        CourseApplicationEntity entity = new CourseApplicationEntity();
        try{
            BeanUtils.copyProperties(entity, dto);
            Boolean isAdded = courseApplicationRepository.save(entity);
            return isAdded;
        }
        catch (IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<CourseApplicationDto> getCourse() {
        List<CourseApplicationEntity> entities = courseApplicationRepository.getApplicationDetails();
        List<CourseApplicationDto> dtoList = new ArrayList<>();
        try{
            for (CourseApplicationEntity entity : entities){
                CourseApplicationDto dto = new CourseApplicationDto();
                BeanUtils.copyProperties(dto, entity);
                dtoList.add(dto);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return dtoList;
    }

    public void deleteById(int id) {
        courseApplicationRepository.deleteById(id);
        if (courseApplicationRepository != null) {
            courseApplicationRepository.deleteById(id);
            System.out.println("User profile with id " + id + " deleted successfully");
        } else {
            System.out.println("User profile with id " + id + " not found");
        }
    }
}
