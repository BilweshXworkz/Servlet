package com.xworkz.travelapp.services;

import com.xworkz.travelapp.dto.TravelBookingDto;
import com.xworkz.travelapp.repository.TravelBookingRepository;

import java.util.List;

public interface TravelBookingServices {
    Boolean validAndSave(TravelBookingDto dto);
    List<TravelBookingDto> getBooking();
    public void deleteById(int id);
    TravelBookingDto getBookingById(int id);
    void updateBooking(TravelBookingDto dto);
}
