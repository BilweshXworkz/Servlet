package com.xworkz.flightapp.repository;

import com.xworkz.flightapp.entity.FlightBookingEntity;

public interface FlightBookingRepository {
    Boolean save(FlightBookingEntity flightBookingEntity);
}
