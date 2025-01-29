package com.xworkz.donationapp.services;

import com.xworkz.donationapp.dto.DonationDto;
import com.xworkz.donationapp.entity.DonationEntity;
import com.xworkz.donationapp.repository.DonationRepository;
import com.xworkz.donationapp.repository.DonationRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;


public class DonationServicesImpl implements DonationServices {
    DonationRepository donationRepository = new DonationRepositoryImpl();

    @Override
    public Boolean ValidAndSave(DonationDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<DonationEntity>> validate = validator.validate(new DonationEntity());
        if (!validate.isEmpty()){
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        DonationEntity entity = new DonationEntity();
        try{
            BeanUtils.copyProperties(entity, dto);
            Boolean isAdded = donationRepository.save(entity);
            return isAdded;
        }
        catch (IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
