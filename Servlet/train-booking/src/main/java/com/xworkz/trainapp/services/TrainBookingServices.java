package com.xworkz.trainapp.services;

import com.xworkz.trainapp.dto.TrainBookingDto;
import com.xworkz.trainapp.entity.TrainBookingEntity;

import java.util.List;

public interface TrainBookingServices {
    Boolean validAndSave(TrainBookingDto dto);
    List<TrainBookingDto> getTrain();
    public void deleteById(int id);
    TrainBookingDto getProfileById(int id);
    void UpdateProfile (TrainBookingDto dto);
}
