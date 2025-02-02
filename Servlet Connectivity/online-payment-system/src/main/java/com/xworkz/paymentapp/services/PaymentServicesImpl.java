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
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<PaymentDto> getPayment() {
        List<PaymetEntity> entities = paymentRepository.getPaymentDetails();
        List<PaymentDto> dtoList = new ArrayList<>();
        try{
            for (PaymetEntity entity : entities){
                PaymentDto dto = new PaymentDto();
                BeanUtils.copyProperties(dto, entity);
                dtoList.add(dto);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return dtoList;
    }

    public void deleteById(int id) {
        paymentRepository.deleteById(id);
        if (paymentRepository != null) {
            paymentRepository.deleteById(id);
            System.out.println("User profile with id " + id + " deleted successfully");
        } else {
            System.out.println("User profile with id " + id + " not found");
        }
    }
}
