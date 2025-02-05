package com.xworkz.appointmentapp.repository;

import com.xworkz.appointmentapp.entity.AppointmentEntity;

import java.util.List;

public interface AppointmentRepository {
    Boolean save(AppointmentEntity appointmentEntity);
    List<AppointmentEntity> getAppointmentDetails();
    void deleteById(int id);
    AppointmentEntity getProfileById(Integer id);
    void updateProfile(AppointmentEntity entity);
}
