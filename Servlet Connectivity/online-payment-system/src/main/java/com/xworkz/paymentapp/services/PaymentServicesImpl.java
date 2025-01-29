package com.xworkz.paymentapp.services;

import com.xworkz.paymentapp.dto.PaymentDto;
import com.xworkz.paymentapp.entity.PaymetEntity;
import com.xworkz.paymentapp.repository.PaymentRepository;
import com.xworkz.paymentapp.repository.PaymentRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class PaymentServicesImpl implements PaymentServices{
    PaymentRepository paymentRepository = new PaymentRepositoryImpl();
    @Override
    public Boolean validAndSave(PaymentDto paymentDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<PaymetEntity>> validate = validator.validate(new PaymetEntity());
        if (!validate.isEmpty()){
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        PaymetEntity entity = new PaymetEntity();
        try{
            BeanUtils.copyProperties(entity, paymentDto);
            Boolean isAdded = paymentRepository.save(entity);
            return isAdded;
        }
        catch (IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
