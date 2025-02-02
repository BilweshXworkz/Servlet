package com.xworkz.trainapp.repository;

import com.xworkz.trainapp.entity.TrainBookingEntity;

import java.util.List;

public interface TrainBookingRepository {
    Boolean save(TrainBookingEntity trainBookingEntity);
    List<TrainBookingEntity> getTrainDetails();
    public void deleteById(int id);
}
