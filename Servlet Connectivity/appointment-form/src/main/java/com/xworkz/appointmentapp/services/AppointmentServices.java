package com.xworkz.appointmentapp.services;

import com.xworkz.appointmentapp.dto.AppointmentDto;

import java.util.List;

public interface AppointmentServices {
    boolean valideAndSave(AppointmentDto dto);
    List<AppointmentDto> getAppointment();
    void deleteById(int id);
}
