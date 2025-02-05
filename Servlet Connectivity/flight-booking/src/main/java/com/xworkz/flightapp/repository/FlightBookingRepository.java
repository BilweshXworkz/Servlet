package com.xworkz.flightapp.repository;

import com.xworkz.flightapp.entity.FlightBookingEntity;

import java.util.List;

public interface FlightBookingRepository {
    Boolean save(FlightBookingEntity flightBookingEntity);
    List<FlightBookingEntity> getFlightDetails();
    void deleteById(int id);
    FlightBookingEntity getFlightById(int id);
    void updateFlight(FlightBookingEntity entity);
}
