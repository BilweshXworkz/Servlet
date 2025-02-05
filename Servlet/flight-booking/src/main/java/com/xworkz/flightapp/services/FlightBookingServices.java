package com.xworkz.flightapp.services;

import com.xworkz.flightapp.dto.FlightBookingDto;
import com.xworkz.flightapp.entity.FlightBookingEntity;

import java.util.List;

public interface FlightBookingServices {
    boolean valideAndSave(FlightBookingDto dto);
    List<FlightBookingDto> getflight();
    void deleteById(int id);
    FlightBookingDto getProfileById(int id);
    void updateProfileById(FlightBookingDto dto);

//    updateProfile();

}
