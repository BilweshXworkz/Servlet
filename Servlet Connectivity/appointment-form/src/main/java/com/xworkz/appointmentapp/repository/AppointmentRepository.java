package com.xworkz.appointmentapp.repository;

import com.xworkz.appointmentapp.entity.AppointmentEntity;

public interface AppointmentRepository {
    Boolean save(AppointmentEntity appointmentEntity);
}
