package com.xworkz.flightapp.services;

import com.xworkz.flightapp.dto.FlightBookingDto;
import com.xworkz.flightapp.entity.FlightBookingEntity;

public interface FlightBookingServices {
    boolean valideAndSave(FlightBookingDto dto);
}
