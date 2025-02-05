package com.xworkz.appointmentapp.services;

import com.xworkz.appointmentapp.dto.AppointmentDto;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface AppointmentServices {
    boolean valideAndSave(AppointmentDto dto);
    List<AppointmentDto> getAppointment();
    void deleteById(int id);
    AppointmentDto getProfileById(Integer id);
    void UpdateProfile(AppointmentDto dto);
}
