package com.xworkz.hotelapp.repository;

import com.xworkz.hotelapp.entity.RoomOrderEntity;

import java.util.List;

public interface RoomOrderRepository {
    Boolean save(RoomOrderEntity roomOrderEntity);
    List<RoomOrderEntity> getOrderDetails();
    void deleteById(int id);
    RoomOrderEntity getBookingById(int id);
    void updateBooking(RoomOrderEntity entity);
}
