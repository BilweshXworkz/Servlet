package com.xworkz.eventapp.services;

import com.xworkz.eventapp.dto.EventDto;
import com.xworkz.eventapp.repository.EventRepository;

import java.util.List;

public interface EventServices {
    Boolean validAndSave(EventDto eventDto);
    List<EventDto> getEvent();
    void deleteById(int id);
}
