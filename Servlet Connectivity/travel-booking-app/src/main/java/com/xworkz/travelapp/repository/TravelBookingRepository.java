package com.xworkz.travelapp.repository;

import com.xworkz.travelapp.entity.TravelingBookingEntity;

import java.util.List;

public interface TravelBookingRepository {
    Boolean save(TravelingBookingEntity travelingBookingEntity);
    List<TravelingBookingEntity> getBookingDetails();
    void deleteById(int id);
    TravelingBookingEntity getBookingById(int id);
    void updateBooking(TravelingBookingEntity entity);
}
