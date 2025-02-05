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
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<DonationDto> getDonation() {
        List<DonationEntity> entities = donationRepository.getDonationDetails();
        List<DonationDto> dtoList = new ArrayList<>();
        try{
            for (DonationEntity entity : entities){
                DonationDto dto = new DonationDto();
                BeanUtils.copyProperties(dto, entity);
                dtoList.add(dto);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return dtoList;
    }
    public void deleteById(int id) {
        donationRepository.deleteById(id);
        if (donationRepository != null) {
            donationRepository.deleteById(id);
            System.out.println("User profile with id " + id + " deleted successfully");
        } else {
            System.out.println("User profile with id " + id + " not found");
        }
    }

    @Override
    public DonationDto getDonationById(int id) {
        if (id > 0){
            DonationDto dto = new DonationDto();
            DonationEntity entity = donationRepository.getDonationById(id);
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
    public void updateDonation(DonationDto dto) {
        DonationEntity entity = new DonationEntity();
        try{
            BeanUtils.copyProperties(entity, dto);
            donationRepository.updateDonation(entity);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
