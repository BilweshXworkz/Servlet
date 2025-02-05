package com.xworkz.trainapp.repository;

import com.xworkz.trainapp.entity.TrainBookingEntity;

import java.util.List;

public interface TrainBookingRepository {
    Boolean save(TrainBookingEntity trainBookingEntity);
    List<TrainBookingEntity> getTrainDetails();
    void deleteById(int id);
    TrainBookingEntity getProfileById(Integer id);
    void updateProfile(TrainBookingEntity entity);
}
