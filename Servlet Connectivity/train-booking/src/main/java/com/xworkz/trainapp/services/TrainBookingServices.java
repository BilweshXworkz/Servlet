package com.xworkz.trainapp.services;

import com.xworkz.trainapp.dto.TrainBookingDto;

public interface TrainBookingServices {
    Boolean validAndSave(TrainBookingDto dto);
}
