package com.xworkz.hotelapp.services;

import com.xworkz.hotelapp.dto.RoomOrderDto;

import java.util.List;

public interface RoomOrderServices {
    Boolean validAndSave(RoomOrderDto dto);
    List<RoomOrderDto> getRoom();
    void deleteById(int id);
}
