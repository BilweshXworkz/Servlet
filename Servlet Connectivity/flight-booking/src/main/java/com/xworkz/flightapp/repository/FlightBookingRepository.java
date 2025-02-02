package com.xworkz.flightapp.repository;

import com.xworkz.flightapp.entity.FlightBookingEntity;

import java.util.List;

public interface FlightBookingRepository {
    Boolean save(FlightBookingEntity flightBookingEntity);
    List<FlightBookingEntity> getFlightDetails();
    void deleteById(int id);
}
