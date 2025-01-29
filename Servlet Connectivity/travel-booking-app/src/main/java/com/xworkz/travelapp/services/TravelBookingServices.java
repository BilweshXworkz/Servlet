package com.xworkz.travelapp.services;

import com.xworkz.travelapp.dto.TravelBookingDto;
import com.xworkz.travelapp.repository.TravelBookingRepository;

public interface TravelBookingServices {
    Boolean validAndSave(TravelBookingDto dto);
}
