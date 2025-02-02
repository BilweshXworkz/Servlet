package com.xworkz.trainapp.services;

import com.xworkz.trainapp.dto.TrainBookingDto;

import java.util.List;

public interface TrainBookingServices {
    Boolean validAndSave(TrainBookingDto dto);
    List<TrainBookingDto> getTrain();
    public void deleteById(int id);
}
