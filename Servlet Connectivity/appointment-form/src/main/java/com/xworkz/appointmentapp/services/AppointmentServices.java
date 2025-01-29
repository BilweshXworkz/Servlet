package com.xworkz.appointmentapp.services;

import com.xworkz.appointmentapp.dto.AppointmentDto;

public interface AppointmentServices {
    boolean valideAndSave(AppointmentDto dto);
}
