package com.xworkz.hotelapp.services;

import com.xworkz.hotelapp.dto.RoomOrderDto;

public interface RoomOrderServices {
    Boolean validAndSave(RoomOrderDto dto);
}
